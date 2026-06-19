package com.example.e_commerce_kmp.features.network.request.auth

import kotlinx.serialization.Serializable

@Serializable
data class UpdateLoggedUserPassWordRequest (
    val currentPassword : String ,
    val password : String ,
    val rePassword : String
)
