package com.example.e_commerce_kmp.features.auth.ui.screens.forgetpassword

import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources

data class NewPassWordStates (
    var email : String? = "" ,
    val passWord : String?="",
    var apiState : Resources<Unit>? = null
)

sealed class NewPassWordEvents{
    data class OnEmailChanged(val email: String) : NewPassWordEvents()
    data class OnPassWordChanged(val newPassWord: String) : NewPassWordEvents()
    object OnChangeClick : NewPassWordEvents()
}
