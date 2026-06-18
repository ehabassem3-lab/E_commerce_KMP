package com.example.e_commerce_kmp.features.auth.domain.usecases

import com.example.e_commerce_kmp.features.auth.domain.reposotories.AuthRepository

class VerifyCodeUseCase(private val authRepository: AuthRepository)  {
    suspend fun call(code: String) : Result<Unit> = authRepository.verifyCode(code)
}