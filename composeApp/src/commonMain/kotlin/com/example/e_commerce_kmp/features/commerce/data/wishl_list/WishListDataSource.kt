package com.example.e_commerce_kmp.features.commerce.data.wishl_list

import com.example.e_commerce_kmp.features.commerce.domain.entities.Product
import com.example.e_commerce_kmp.features.network.response.wish.WishResponse

interface WishListDataSource  {
    suspend fun  getUserWishList() : Result<WishResponse>
    suspend fun addWishToList (productId: String) : Result<WishResponse>
    suspend fun removeFromWish(productId: String) : Result<WishResponse>
}