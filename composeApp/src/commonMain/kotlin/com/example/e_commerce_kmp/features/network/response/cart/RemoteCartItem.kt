package com.example.e_commerce_kmp.features.network.response.cart

import com.example.e_commerce_kmp.features.network.response.home.products_response.RemoteProduct
import kotlinx.serialization.Serializable

@Serializable
data class RemoteCartItem(
	val product: RemoteProduct? = null,
	val price: Int? = null,
	val count: Int? = null,
	val id: String? = null
)
