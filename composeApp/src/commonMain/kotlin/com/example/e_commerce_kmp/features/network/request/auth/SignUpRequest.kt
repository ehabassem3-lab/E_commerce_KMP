package com.example.e_commerce_kmp.features.network.request.auth

import kotlinx.serialization.Serializable

@Serializable
data class SignUpRequest(
    val name : String ,
    val email : String ,
    val password : String ,
    val rePassword : String ,
    val  phone : String
                       )