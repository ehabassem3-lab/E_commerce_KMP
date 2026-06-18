package com.example.e_commerce_kmp.features.auth.ui.screens.forgetpassword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.auth.domain.usecases.ForgetPassWordUseCase
import com.example.e_commerce_kmp.features.auth.domain.usecases.VerifyCodeUseCase
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class VerifyCodeViewModel(private  val useCase: VerifyCodeUseCase): ViewModel() {
    val states : MutableStateFlow<VerifyPassWordStates>  = MutableStateFlow(VerifyPassWordStates())


    fun doAction(events: VerifyPassWordEvents){
         when (events){
             is VerifyPassWordEvents.OnCodeChanged -> {
                 states.value =states.value.copy(code = events.code)
             }
             VerifyPassWordEvents.OnVerifyClick -> verify()
         }
    }

    private fun verify() {
       viewModelScope.launch {
           states.value = states.value.copy(apiState = Resources.Loading)
           val  request = useCase.call(states.value.code?:"")
           if (request.isSuccess){
               println(request.getOrNull())
               states.value =states.value.copy(apiState = Resources.Success(request.getOrNull()))
           }else{
               states.value =states.value.copy(apiState = Resources.Error(Throwable(request.exceptionOrNull())))
           }
       }
    }

}