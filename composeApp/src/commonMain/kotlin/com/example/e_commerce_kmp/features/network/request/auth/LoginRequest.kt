package com.example.e_commerce_kmp.features.network.request.auth

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val email : String  ,
    val password : String
)