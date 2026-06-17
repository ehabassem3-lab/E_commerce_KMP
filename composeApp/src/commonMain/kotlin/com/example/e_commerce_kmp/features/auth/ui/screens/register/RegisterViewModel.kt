package com.example.e_commerce_kmp.features.auth.ui.screens.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_kmp.features.auth.domain.reposotories.AuthRepository
import com.example.e_commerce_kmp.features.auth.domain.usecases.LoginUseCase
import com.example.e_commerce_kmp.features.auth.domain.usecases.SignUpUseCase
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RegisterViewModel(var useCase: SignUpUseCase) : ViewModel() {

  val state : MutableStateFlow<RegisterStates> =  MutableStateFlow(RegisterStates())


    fun doAction(event: RegisterEvents){
        when(event){
            is RegisterEvents.OnEmailChange -> {
                state.value = state.value.copy(email =  event.email)
            }
            is RegisterEvents.OnNameChanged -> {
                state.value = state.value.copy(name =  event.name)

            }
            is RegisterEvents.OnPasswordChange ->{
                state.value = state.value.copy(password =  event.password)
            }
            is RegisterEvents.OnPhoneChanged -> {
                state.value = state.value.copy(phone =  event.phone)

            }
            RegisterEvents.OnSignUpClick -> signUp()


        }

    }

    private fun signUp() {
        println("1️⃣ signUp() called")

        viewModelScope.launch {
            println("2️⃣ inside coroutine")

            state.value =state.value.copy(apiState = Resources.Loading)
            println("3️⃣ before useCase.call")

            val request = useCase.call(
                state.value.email ?: "",
                state.value.password ?: "",
                state.value.phone ?: "",
                state.value.name ?: "",
            )
            println("4️⃣ after useCase.call: $request")
            if (request.isSuccess){
                state.value = state.value.copy(apiState = Resources.Success() )
            }else{
                state.value = state.value.copy(apiState = Resources.Error(Throwable(request.exceptionOrNull())))
            }
        }

    }
}