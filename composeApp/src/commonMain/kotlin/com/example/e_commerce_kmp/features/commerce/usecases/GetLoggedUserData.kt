package com.example.e_commerce_kmp.features.commerce.usecases

import com.example.e_commerce_kmp.features.auth.domain.reposotories.AuthRepository
import com.example.e_commerce_kmp.features.network.response.auth.UserDataResponse

class GetLoggedUserData(private  val repository: AuthRepository) {
    suspend fun  call() : Result<UserDataResponse> = repository.getUserData()
}