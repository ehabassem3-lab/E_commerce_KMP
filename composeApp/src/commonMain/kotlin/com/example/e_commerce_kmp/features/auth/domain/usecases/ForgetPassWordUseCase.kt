package com.example.e_commerce_kmp.features.auth.domain.usecases

import com.example.e_commerce_kmp.features.auth.domain.reposotories.AuthRepository

class ForgetPassWordUseCase(private val  authRepository: AuthRepository) {
    suspend fun call(email: String) : Result<Unit> = authRepository.forgetPassWord(email)
}