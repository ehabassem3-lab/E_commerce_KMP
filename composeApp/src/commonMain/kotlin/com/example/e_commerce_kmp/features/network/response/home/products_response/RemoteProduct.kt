package com.example.e_commerce_kmp.features.network.response.home.products_response

import com.example.e_commerce_kmp.features.network.response.home.categories_response.RemoteCategory
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteProduct(
	val sold: Int? = null,
	val images: List<String?>? = null,
	val quantity: Int? = null,
	val availableColors: List<String?>? = null,
	val imageCover: String? = null,
	val description: String? = null,
	val title: String? = null,
	val ratingsQuantity: Double? = null,
	val ratingsAverage: Double? = null,
	val createdAt: String? = null,
	val price: Double? = null,
	@SerialName("_id")
	val id: String? = null,
	val subcategory: List<RemoteCategory?>? = null,
	val category: RemoteCategory? = null,
	val brand: RemoteCategory? = null,
	val slug: String? = null,
	val updatedAt: String? = null,
	val priceAfterDiscount: Double? = null
)
