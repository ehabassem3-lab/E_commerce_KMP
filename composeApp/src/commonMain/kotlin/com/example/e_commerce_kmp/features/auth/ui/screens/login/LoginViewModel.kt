package com.example.e_commerce_kmp.features.auth.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_kmp.features.auth.domain.usecases.LoginUseCase
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(var loginUseCase: LoginUseCase): ViewModel(){
    var loginState : MutableStateFlow<LoginStates> = MutableStateFlow(LoginStates())

    fun doAction(){

    }

   private fun login (){
        viewModelScope.launch {
            loginState.value.apiState = Resources.idle
            val result = loginUseCase.call(loginState.value.email?:"" ,loginState.value.password?:""  )
          if (result.isSuccess){
              loginState.value.apiState = Resources.Loading
          }else{
              loginState.value.apiState = Resources.Error(result.exceptionOrNull()!!, result.exceptionOrNull()?.message)
          }
        }

    }


}