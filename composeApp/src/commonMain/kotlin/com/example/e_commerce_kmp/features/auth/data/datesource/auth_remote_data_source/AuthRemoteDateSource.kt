package com.example.e_commerce_kmp.features.auth.data.datesource.auth_remote_data_source

import com.example.e_commerce_kmp.features.network.response.auth.AuthResponse

interface AuthRemoteDateSource {
    suspend fun login(email : String , password : String) : Result<AuthResponse>
}