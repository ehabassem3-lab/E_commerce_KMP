package com.example.e_commerce_kmp.features.commerce.domain.entities

data class Cart(
    val product: Map< String ,Product> ,
    val totalPrice : Double
)
