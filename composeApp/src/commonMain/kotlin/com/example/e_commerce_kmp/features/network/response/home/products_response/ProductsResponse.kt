package com.example.e_commerce_kmp.features.network.response.home.products_response

import com.example.e_commerce_kmp.features.network.response.home.Metadata
import com.example.e_commerce_kmp.features.network.response.home.categories_response.RemoteCategory
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductsResponse(
	val metadata: Metadata? = null,
	@SerialName("data")
	val products: List<RemoteProduct>,

	val results: Int? = null
)
