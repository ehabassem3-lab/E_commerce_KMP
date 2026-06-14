package com.example.e_commerce_kmp.features.commerce.data.cart.repository

import androidx.compose.ui.graphics.findFirstRoot
import com.example.e_commerce_kmp.features.commerce.data.cart.CartRemoteDateSource
import com.example.e_commerce_kmp.features.commerce.domain.entities.Cart
import com.example.e_commerce_kmp.features.commerce.domain.repositories.CartRepository
import com.example.e_commerce_kmp.features.commerce.mappers.toCart

class CartRepositoryImpl(private  val cartRemoteDateSource: CartRemoteDateSource) : CartRepository {
    override suspend fun getCart(): Result<Cart> {
       val request = cartRemoteDateSource.getCart()
        val response = request.getOrNull()
        return if (request.isSuccess  && response != null && response.cart != null){
            Result.success(response.cart.toCart())
        }else{
            Result.failure(Throwable("Error in the Else Barnch From get CArt Repo"))

        }
    }

    override suspend fun addProductToCart(productId: String): Result<Cart> {
       val request = cartRemoteDateSource.addProductToCart(productId)
        val response = request.getOrNull()
        return if (request.isSuccess  && response != null && response.cart != null){
            Result.success(response.cart.toCart())
        }else{
            Result.failure(Throwable("Error in the Else Barnch From Adding  CArt Repo"))

        }
    }

    override suspend fun deleteProduct(productId: String): Result<Cart> {
       val request = cartRemoteDateSource.deleteProduct(productId)
        val response = request.getOrNull()
        return if (request.isSuccess  && response != null && response.cart != null){
            Result.success(response.cart.toCart())
        }else{
            Result.failure(Throwable("Error in the Else Barnch From deleting  CArt Repo"))

        }
    }

    override suspend fun updateCart(
        productId: String,
        quantity: Int
    ): Result<Cart> {
        val request = cartRemoteDateSource.updateCart(productId , quantity)
        val response = request.getOrNull()
        return  if (request.isSuccess && response != null && response.cart!= null){
            Result.success(response.cart.toCart())
        }else{
            Result.failure(Throwable("Error in the Else Barnch From Updating  CArt Repo"))


        }
    }
}