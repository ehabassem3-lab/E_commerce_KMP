package com.example.e_commerce_kmp.features.auth.ui.screens.forgetpassword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.e_commerce_kmp.features.auth.domain.usecases.ForgetPassWordUseCase
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ForgetPassWordViewModel(private val useCase: ForgetPassWordUseCase) : ViewModel(){
    val state : MutableStateFlow<ForgetPassWordStates> = MutableStateFlow(ForgetPassWordStates())

    fun doAction(events: ForgetPassWordEvents){
        when(events){
            is ForgetPassWordEvents.OnEmailChanged -> {
                state.value = state.value.copy(email = events.email)
            }
            ForgetPassWordEvents.OnForgetPassWordClick -> forgetPassWord()
        }
    }

    private fun forgetPassWord() {
        viewModelScope.launch {
            state.value= state.value.copy(apiState = Resources.Loading)
            val request = useCase.call(state.value.email?:"")
            if (request.isSuccess){
                state.value= state.value.copy(apiState = Resources.Success(request.getOrNull()))
            }else{
                state.value= state.value.copy(apiState = Resources.Error(Throwable (request.exceptionOrNull())))

            }

        }
    }

}