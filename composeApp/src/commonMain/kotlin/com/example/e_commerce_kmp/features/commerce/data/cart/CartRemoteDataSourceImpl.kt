package com.example.e_commerce_kmp.features.commerce.data.cart

import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.commerce.data.home_repository.remote_data_source.HomeRemoteDataSource
import com.example.e_commerce_kmp.features.commerce.mappers.toCart
import com.example.e_commerce_kmp.features.network.request.cart.AddToCartRequest
import com.example.e_commerce_kmp.features.network.request.cart.UpdateCartRequest
import com.example.e_commerce_kmp.features.network.response.cart.CartResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody

class CartRemoteDataSourceImpl(val httpClient: HttpClient) : CartRemoteDateSource {
    val url = "v1/cart"
    override suspend fun getCart(): Result<CartResponse> {
        try {
            val request = httpClient.get(url)
            val response = request.body<CartResponse>()
            return Result.success(response)

        } catch (t : Throwable){
               return Result.failure(Throwable("Error While Getting The Cart Form The Data Source"))
        }

    }

    override suspend fun addProductToCart(productId: String): Result<CartResponse> {
        try {
            val request = httpClient.post(url){ setBody(AddToCartRequest(productId)) }
            val response = request.body<CartResponse>()
            return Result.success(response)

        }catch (t : Throwable){
             return Result.failure(Throwable("Error While Adding TO Cart Form The Data Source"))
        }

    }

    override suspend fun deleteProduct(productId: String) : Result<CartResponse >{
        try {
            val request = httpClient.delete("$url/$productId")
            val response = request.body<CartResponse>()
            return Result.success(response)
        }catch (t : Throwable){
            return Result.failure(Throwable("Error While Deleting  TO Cart Form The Data Source"))
        }

    }

    override suspend fun updateCart(
        productId: String,
        quantity: Int
    ): Result<CartResponse> {
        try {
            val request = httpClient.put ("$url/$productId"){ setBody(UpdateCartRequest(quantity)) }
            val response = request.body<CartResponse>()
            return Result.success(response)
        }catch (t : Throwable){
            return Result.failure(Throwable("Error While Updating TO Cart Form The Data Source"))
        }

    }
}