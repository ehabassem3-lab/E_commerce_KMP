package com.example.e_commerce_kmp.features.auth.ui.screens.register

import com.example.e_commerce_kmp.features.auth.ui.screens.login.LoginEvents
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources

data class RegisterStates (
    var email : String? = "" ,
    var password : String? ="" ,
    val phone : String? = "",
    val name : String? ="" ,
    var apiState : Resources<Unit>? = null
)
sealed class  RegisterEvents{
    data class OnEmailChange(  val email: String) : RegisterEvents()
    data class OnPasswordChange(  val password: String) : RegisterEvents()
    data class OnPhoneChanged(  val phone: String) : RegisterEvents()
    data class OnNameChanged(  val name: String) : RegisterEvents()
    object   OnSignUpClick : RegisterEvents()


}