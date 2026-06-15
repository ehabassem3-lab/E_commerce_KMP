package com.example.e_commerce_kmp.features.network.response.wish

import com.example.e_commerce_kmp.features.network.response.home.products_response.RemoteProduct
import kotlinx.serialization.Serializable

@Serializable

data class WishResponse(
	val data: List<RemoteWish?>? = null,
	val count: Int? = null,
	val status: String? = null
)
