package com.example.e_commerce_kmp.features.auth.ui.screens.login

sealed class  LoginEvents{
    data class OnEmailChange(  val email: String) : LoginEvents()
    data class OnPasswordChange(  val password: String) : LoginEvents()
    object  OnLogiClick : LoginEvents()
    object  OnForgetPassword : LoginEvents()
    object  OnRegisterClick : LoginEvents()


}
