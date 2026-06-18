package com.example.e_commerce_kmp.features.commerce.ui.tabs.account

import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.network.response.auth.UserDataResponse

data class AccountStates (
    val LogOutState : Resources<Unit>? = null ,
    val AccountDataStates : Resources<UserDataResponse>? = null
)
sealed class AccountEvents {
    object  onLogOutClick : AccountEvents()
    object getUserData : AccountEvents()

}
