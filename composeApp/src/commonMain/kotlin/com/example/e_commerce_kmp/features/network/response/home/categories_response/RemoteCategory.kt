package com.example.e_commerce_kmp.features.network.response.home.categories_response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteCategory(
	val image: String? = null,
	val createdAt: String? = null,
	val name: String? = null,
	@SerialName("_id")
	val id: String? = null,
	val slug: String? = null,
	val category: String? = null,
	val updatedAt: String? = null
)
