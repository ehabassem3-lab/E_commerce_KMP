package com.example.e_commerce_kmp.features.auth.ui.screens.forgetpassword

import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources

data class VerifyPassWordStates(
    var code : String? = "" ,
    var apiState : Resources<Unit>? = null
            )

sealed class VerifyPassWordEvents{
    data class  OnCodeChanged(val code : String ) : VerifyPassWordEvents()
    object  OnVerifyClick : VerifyPassWordEvents()
}