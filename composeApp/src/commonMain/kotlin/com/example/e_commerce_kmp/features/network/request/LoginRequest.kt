package com.example.e_commerce_kmp.features.network.request

import kotlinx.serialization.Serializable


@Serializable
data class LoginRequest(
    val email : String  ,
    val password : String
)


