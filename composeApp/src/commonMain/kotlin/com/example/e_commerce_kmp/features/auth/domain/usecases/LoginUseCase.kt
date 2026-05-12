package com.example.e_commerce_kmp.features.auth.domain.usecases

import com.example.e_commerce_kmp.features.auth.domain.reposotories.AuthRepository

class LoginUseCase(private  var authrepo : AuthRepository){
  suspend   fun call(email : String , password : String ) : Result<Unit> =
      authrepo.login(email, password)



}