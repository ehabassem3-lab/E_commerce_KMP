package com.example.e_commerce_kmp.features.commerce.domain.entities

import com.example.e_commerce_kmp.features.network.response.home.categories_response.RemoteCategory
import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val sold: Int? = null,
    val images: List<String?>? = null,
    var quantity: Int? = null,
    val availableColors: List<String?>? = null,
    val imageCover: String? = null,
    val description: String? = null,
    val title: String? = null,
    val ratingsQuantity: Double? = null,
    val ratingsAverage: Double? = null,
    val price: Double? = null,
    val id: String? = null,
    val priceAfterDiscount: Double? = null ,
    var cartQuantity  : Int ? = 0
)