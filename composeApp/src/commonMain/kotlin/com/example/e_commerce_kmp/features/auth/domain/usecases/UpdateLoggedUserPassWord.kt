package com.example.e_commerce_kmp.features.auth.domain.usecases

import com.example.e_commerce_kmp.features.auth.domain.reposotories.AuthRepository

class UpdateLoggedUserPassWordUseCase(private  val authRepository: AuthRepository){
    suspend fun call(currentPassWord : String ,passWord : String , rePassWord : String) : Result<Unit> = authRepository.updateUserPassWord(currentPassWord,passWord,rePassWord)
}