package com.example.e_commerce_kmp.features.network.response.home.categories_response

import kotlinx.serialization.Serializable

@Serializable
data class RemoteCategory(
	val image: String? = null,
	val createdAt: String? = null,
	val name: String? = null,
	val id: String? = null,
	val slug: String? = null,
	val category: String  ,
	val updatedAt: String? = null
)
