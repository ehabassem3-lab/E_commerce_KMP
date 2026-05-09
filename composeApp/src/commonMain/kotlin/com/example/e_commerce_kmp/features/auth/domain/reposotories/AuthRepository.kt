package com.example.e_commerce_kmp.features.auth.domain.reposotories

import com.example.e_commerce_kmp.features.network.response.AuthResponse

interface AuthRepository {
    suspend fun login(email : String , password : String) : Result<Unit>
}