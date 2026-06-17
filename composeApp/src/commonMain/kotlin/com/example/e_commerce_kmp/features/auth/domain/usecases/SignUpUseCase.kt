package com.example.e_commerce_kmp.features.auth.domain.usecases

import com.example.e_commerce_kmp.features.auth.domain.reposotories.AuthRepository

class SignUpUseCase (private  var authrepo : AuthRepository){

    suspend   fun call(email : String , password : String, number : String , name : String) : Result<Unit> =
        authrepo.signUp(name, email,password, rePassword = password, number )



}