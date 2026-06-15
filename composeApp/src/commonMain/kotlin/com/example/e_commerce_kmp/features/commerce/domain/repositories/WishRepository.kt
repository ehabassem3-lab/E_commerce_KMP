package com.example.e_commerce_kmp.features.commerce.domain.repositories

import com.example.e_commerce_kmp.features.commerce.domain.entities.Product
import com.example.e_commerce_kmp.features.network.response.wish.WishResponse

interface WishRepository {
    suspend fun  getWishList() : Result<WishResponse>
    suspend fun  addWish(productId: String) : Result<WishResponse>
    suspend fun  removeWish(productId: String) : Result<WishResponse>
}