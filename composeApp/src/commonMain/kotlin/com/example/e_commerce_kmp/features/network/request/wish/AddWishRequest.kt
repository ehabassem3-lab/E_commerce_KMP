package com.example.e_commerce_kmp.features.network.request.wish

import kotlinx.serialization.Serializable

@Serializable
data class AddWishRequest(
    val productId: String
)