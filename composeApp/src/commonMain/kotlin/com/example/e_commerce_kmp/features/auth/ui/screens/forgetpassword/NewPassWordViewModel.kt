package com.example.e_commerce_kmp.features.auth.ui.screens.forgetpassword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_kmp.features.auth.domain.usecases.ResetPassWordUseCase
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class NewPassWordViewModel(private  val useCase: ResetPassWordUseCase) : ViewModel(){
    val state : MutableStateFlow<NewPassWordStates> = MutableStateFlow(NewPassWordStates())


    fun doAction(events: NewPassWordEvents){
        when(events){
            NewPassWordEvents.OnChangeClick -> changePassWord()
            is NewPassWordEvents.OnEmailChanged -> {
                state.value = state.value.copy(email = events.email)
            }
            is NewPassWordEvents.OnPassWordChanged -> {
                state.value = state.value.copy(passWord = events.newPassWord)

            }
        }

    }

    private fun changePassWord() {
        viewModelScope.launch {
            state.value = state.value.copy(apiState = Resources.Loading)
            val request = useCase.call(
                state.value.email?:"" , state.value.passWord?:""
            )
            if (request.isSuccess){
                println(request.getOrNull())
                state.value =state.value.copy(apiState = Resources.Success(request.getOrNull()))
            }else{
                state.value =state.value.copy(apiState = Resources.Error(Throwable(request.exceptionOrNull())))
            }
        }
    }

}