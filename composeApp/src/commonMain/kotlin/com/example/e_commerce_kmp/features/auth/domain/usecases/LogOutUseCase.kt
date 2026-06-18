package com.example.e_commerce_kmp.features.auth.domain.usecases

import com.example.e_commerce_kmp.features.auth.domain.reposotories.AuthRepository

class LogOutUseCase( private  val authRepository: AuthRepository) {
    suspend fun logOut() : Result<Unit> = authRepository.logOut()
}