package com.example.e_commerce_kmp.features.commerce.ui.tabs.account

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.auth.domain.usecases.LogOutUseCase
import com.example.e_commerce_kmp.features.auth.domain.usecases.UpdateLoggedUserPassWordUseCase
import com.example.e_commerce_kmp.features.auth.domain.usecases.UpdateUserDataUseCase
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.commerce.usecases.GetLoggedUserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.io.files.Path

class AccountViewModel(
    private  val useCase: LogOutUseCase ,
    private val getUserDataUseCase : GetLoggedUserData,
    private val updateUserDataUseCase: UpdateUserDataUseCase ,
    private val updateLoggedUserPassWordUseCase: UpdateLoggedUserPassWordUseCase
) : ViewModel() {

    val state : MutableStateFlow<AccountStates> = MutableStateFlow(AccountStates())

    fun doAction(events: AccountEvents){
        when(events){
            AccountEvents.onLogOutClick -> logOut()
            AccountEvents.getUserData -> getUserData()
            is AccountEvents.OnEmailChanged ->{
                state.value = state.value.copy(email = events.email)
            }
            is AccountEvents.OnNameChanged -> {
                state.value = state.value.copy(name = events.name)

            }
            is AccountEvents.OnPhoneChanged -> {
                state.value = state.value.copy(phone = events.phone)

            }
            AccountEvents.updateUserDate -> updateUserDate()
            is AccountEvents.OnCurrentPassWordChange -> {
                state.value = state.value.copy(currentPassWord = events.currentPassWord)
            }
            is AccountEvents.OnPassWordChange -> {
                state.value = state.value.copy(passWord = events.passWord)
            }
            is AccountEvents.OnRePassWordChange -> {
                state.value = state.value.copy(rePassWord = events.rePassWord)
            }
            AccountEvents.updateUserPassWord -> updateUserPassWord()
        }

    }

    private fun updateUserPassWord() {
      viewModelScope.launch {
          state.value = state.value.copy(UpdateUserPassWorApi = Resources.Loading)
          val request = updateLoggedUserPassWordUseCase.call(
              state.value.currentPassWord?:"",
              state.value.passWord?:"",
              state.value.rePassWord?:""
          )
          if (request.isSuccess){
              println(request.getOrNull())
              state.value = state.value.copy(UpdateUserPassWorApi = Resources.Success(request.getOrNull()))
          }else{
              println(request.getOrNull())
              state.value = state.value.copy(UpdateUserPassWorApi = Resources.Error(Throwable(request.exceptionOrNull())))

          }
      }
    }

    private fun updateUserDate() {
        viewModelScope.launch {
            state.value = state.value.copy(UpdateUserDateApi = Resources.Loading)
            val request = updateUserDataUseCase.call(
                state.value.name?:"",
                state.value.email?:"",
                state.value.phone?:""
            )
            if (request.isSuccess){
                println(request.getOrNull())
                state.value = state.value.copy(UpdateUserDateApi = Resources.Success(request.getOrNull()))
            }else{
                println(request.getOrNull())
                state.value = state.value.copy(UpdateUserDateApi = Resources.Error(Throwable(request.exceptionOrNull())))
            }
        }
    }

    private fun getUserData() {
       viewModelScope.launch {
           state.value = state.value.copy(AccountDataStates = Resources.Loading)
           val  request = getUserDataUseCase.call()
           if (request.isSuccess){
            state.value = state.value.copy(AccountDataStates = Resources.Success(request.getOrNull()))
           }else{
               state.value = state.value.copy(AccountDataStates = Resources.Error(Throwable(request.exceptionOrNull())))

           }
       }
    }

    private fun logOut() {
        viewModelScope.launch {
        state.value = state.value.copy(LogOutState = Resources.Loading)
        val request =useCase.logOut()
            if (request.isSuccess){
                state.value = state.value.copy(LogOutState = Resources.Success())
            }else {
            state.value = state.value.copy(LogOutState = Resources.Error(Throwable("Error While LogOut")))
            }

        }

    }

}