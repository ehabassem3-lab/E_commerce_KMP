package com.example.e_commerce_kmp.features.auth.ui.screens.forgetpassword

import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources

data class ForgetPassWordStates (
    var email : String? = "" ,
    var apiState : Resources<Unit>? = null
)

sealed class ForgetPassWordEvents{
    data class OnEmailChanged(val email : String) : ForgetPassWordEvents()
    object OnForgetPassWordClick : ForgetPassWordEvents()
}