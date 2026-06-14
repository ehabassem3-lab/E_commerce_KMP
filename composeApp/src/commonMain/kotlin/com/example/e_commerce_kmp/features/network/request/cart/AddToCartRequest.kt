package com.example.e_commerce_kmp.features.network.request.cart

import kotlinx.serialization.Serializable

@Serializable
data class AddToCartRequest (
    val productId : String
)
