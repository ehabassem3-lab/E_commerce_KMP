package com.example.e_commerce_kmp.features.auth.ui.screens.login

import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_kmp.features.auth.domain.usecases.LoginUseCase
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(var loginUseCase: LoginUseCase): ViewModel(){
    var loginState : MutableStateFlow<LoginStates> = MutableStateFlow(LoginStates())

    fun doAction(events: LoginEvents){

        when(events){
           is LoginEvents.OnLogiClick->{
               login()




            }
            is   LoginEvents.OnEmailChange->{

                loginState.value = loginState.value.copy(email = events.email)
            }
            is   LoginEvents.OnPasswordChange->{
                loginState.value = loginState.value.copy(password = events.password)

            }
            is    LoginEvents.OnRegisterClick->{

            }
            is  LoginEvents.OnForgetPassword->{

            }

        }

    }


   private fun login() {
        viewModelScope.launch {
            loginState.value =loginState.value.copy(apiState = Resources.Loading)
            val result = loginUseCase.call(loginState.value.email?:"" ,loginState.value.password?:""  )
          if (result.isSuccess){
              loginState.value =loginState.value.copy(apiState = Resources.Success())

          }else{
              loginState.value =loginState.value.copy(apiState = Resources.Error(result.exceptionOrNull()!!, result.exceptionOrNull()?.message))

          }
        }

    }


}