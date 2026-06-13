package com.example.e_commerce_kmp.features.network.response.cart

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CartResponse(
	@SerialName("data")
	val cart: RemoteCart? = null,
	val numOfCartItems: Int? = null,
	val cartId: String? = null,
	val status: String? = null
)
