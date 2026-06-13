package com.example.e_commerce_kmp.features.network.response.cart

import kotlinx.serialization.Serializable

@Serializable

data class RemoteCart(
	val cartOwner: String? = null,
	val createdAt: String? = null,
	val totalCartPrice: Double? = null,
	val v: Int? = null,
	val id: String? = null,
	val products: List<RemoteCartItem?>? = null,
	val updatedAt: String? = null
)
