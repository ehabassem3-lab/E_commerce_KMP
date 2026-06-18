package com.example.e_commerce_kmp.features.auth.domain.usecases

import com.example.e_commerce_kmp.features.auth.domain.reposotories.AuthRepository

class ResetPassWordUseCase(private val  authRepository: AuthRepository) {
    suspend fun call(email : String , newPassWord: String ) : Result<Unit> = authRepository.resetPassWord(email,newPassWord)
}