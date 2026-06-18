package com.example.e_commerce_kmp.features.commerce.ui.tabs.account

import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources

data class AccountStates (
    val LogOutState : Resources<Unit>? = null
)
sealed class AccountEvents {
    object  onLogOutClick : AccountEvents()
}
