package com.example.e_commerce_kmp.features.network.request.auth

import kotlinx.serialization.Serializable

@Serializable
data class UpdateUserDataRequest (
    val name : String ,
    val email : String ,
    val phone : String ,
)