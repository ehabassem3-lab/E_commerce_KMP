package com.example.e_commerce_kmp.features.commerce.domain.entities

import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val image: String? = null,
    val name: String? = null,
    val id: String? = null,
   val  category: String
)