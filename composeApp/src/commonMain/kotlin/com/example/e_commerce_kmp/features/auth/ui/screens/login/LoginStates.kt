package com.example.e_commerce_kmp.features.auth.ui.screens.login

import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources

data  class LoginStates(
    var email : String? = "" ,
     var password : String? ="" ,
    var apiState : Resources<Unit>? = null

)
