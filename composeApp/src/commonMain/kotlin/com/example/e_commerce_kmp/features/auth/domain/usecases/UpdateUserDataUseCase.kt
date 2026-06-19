package com.example.e_commerce_kmp.features.auth.domain.usecases

import com.example.e_commerce_kmp.features.auth.domain.reposotories.AuthRepository
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources

class UpdateUserDataUseCase(private  val authRepository: AuthRepository) {
    suspend fun call(name : String ,email: String , phone: String) : Result<Unit> = authRepository.updateUserData(name,email,phone)
}