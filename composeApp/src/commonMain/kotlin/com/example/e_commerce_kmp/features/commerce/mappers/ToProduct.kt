package com.example.e_commerce_kmp.features.commerce.mappers

import com.example.e_commerce_kmp.features.commerce.domain.entities.Product
import com.example.e_commerce_kmp.features.network.response.home.products_response.RemoteProduct


fun RemoteProduct.toProduct() = Product(
    sold = sold ?: 0,
    images = images ?: emptyList(),
    quantity = quantity ?: 0,
    availableColors = availableColors ?: emptyList(),
    imageCover = imageCover ?: "",
    description = description ?: "",
    title = title ?: "",
    ratingsQuantity = ratingsQuantity ?: 0.0,
    ratingsAverage = ratingsAverage ?: 0.0,
    price = price ?: 0.0,
    id = id ?: "",
    priceAfterDiscount = priceAfterDiscount ?: 0.0
)