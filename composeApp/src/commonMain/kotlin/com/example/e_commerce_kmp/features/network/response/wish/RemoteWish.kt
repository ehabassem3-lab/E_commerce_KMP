package com.example.e_commerce_kmp.features.network.response.wish

import com.example.e_commerce_kmp.features.network.response.home.categories_response.RemoteCategory
import com.example.e_commerce_kmp.features.network.response.home.products_response.RemoteProduct
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

data class RemoteWish(
	val sold: Int? = null,
	val images: List<String?>? = null,
	val quantity: Int? = null,
	val imageCover: String? = null,
	val description: String? = null,
	val title: String? = null,
	val ratingsQuantity: Int? = null,
	val ratingsAverage: Double? = null,
	val createdAt: String? = null,
	val price: Int? = null,
	val v: Int? = null,
	val id: String? = null,
	val subcategory: List<RemoteCategory?>? = null,
	val category: RemoteCategory? = null,
	val brand: RemoteProduct? = null,
	val slug: String? = null,
	val updatedAt: String? = null ,
	val WishCliked  : Boolean? = null ,
)
