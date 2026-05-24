package com.example.e_commerce_kmp.features.network.response.auth

import kotlinx.serialization.Serializable


@Serializable
data class AuthResponse(
    val message : String? = null ,
    val user : User? = null ,
    val token  : String? = null
)

@Serializable
data class User(
    val name : String? = null ,
    val email : String? = null ,
    val role : String? = null
)