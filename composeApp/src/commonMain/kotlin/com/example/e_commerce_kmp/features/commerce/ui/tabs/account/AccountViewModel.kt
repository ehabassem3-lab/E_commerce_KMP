package com.example.e_commerce_kmp.features.commerce.ui.tabs.account

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_kmp.features.auth.domain.usecases.LogOutUseCase
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.io.files.Path

class AccountViewModel(private  val useCase: LogOutUseCase) : ViewModel() {

    val state : MutableStateFlow<AccountStates> = MutableStateFlow(AccountStates())

    fun doAction(events: AccountEvents){
        when(events){
            AccountEvents.onLogOutClick -> logOut()
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