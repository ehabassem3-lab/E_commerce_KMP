package com.example.e_commerce_kmp.features.network.response.home.categories_response

import com.example.e_commerce_kmp.features.network.response.home.Metadata
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoriesResponse(
	val metadata: Metadata? = null,
	@SerialName("data")
	val categories: List<RemoteCategory>,
	val results: Int? = null
)
