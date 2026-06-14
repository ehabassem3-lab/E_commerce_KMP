package com.example.e_commerce_kmp.features.commerce.data.cart

import com.example.e_commerce_kmp.features.commerce.domain.entities.Product
import com.example.e_commerce_kmp.features.network.response.cart.CartResponse

interface CartRemoteDateSource {

    suspend fun getCart() : Result<CartResponse>
    suspend fun addProductToCart(productId: String) :  Result<CartResponse>
    suspend fun deleteProduct(productId: String ) : Result<CartResponse>
    suspend fun updateCart(productId: String , quantity : Int) : Result<CartResponse>
}