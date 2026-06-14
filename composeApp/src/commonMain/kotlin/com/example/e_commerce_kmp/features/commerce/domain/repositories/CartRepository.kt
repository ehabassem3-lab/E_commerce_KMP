package com.example.e_commerce_kmp.features.commerce.domain.repositories

import com.example.e_commerce_kmp.features.commerce.domain.entities.Cart
import com.example.e_commerce_kmp.features.network.response.cart.CartResponse

interface CartRepository {
    suspend fun getCart() : Result<Cart>
    suspend fun addProductToCart(productId: String) :  Result<Cart>
    suspend fun deleteProduct(productId: String ) : Result<Cart>
    suspend fun updateCart(productId: String , quantity : Int) : Result<Cart>
}