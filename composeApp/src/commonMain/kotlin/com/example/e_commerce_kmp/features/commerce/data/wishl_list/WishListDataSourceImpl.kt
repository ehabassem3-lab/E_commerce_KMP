package com.example.e_commerce_kmp.features.commerce.data.wishl_list

import com.example.e_commerce_kmp.features.network.response.wish.WishResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class WishListDataSourceImpl( val httpClient: HttpClient) : WishListDataSource {
    val url = "v1/wishlist"
    override suspend fun getUserWishList() : Result<WishResponse> {
        try {
            val request = httpClient.get(url)
            val response = request.body<WishResponse>()
            println(response.data)
            return Result.success(response)
        }catch (e : Throwable){
              return Result.failure(Throwable("error in the get Wish"))
        }
    }



    override suspend fun addWishToList(productId: String): Result<WishResponse>{
        try {
            val request = httpClient.post(url){ setBody(productId) }
            val response = request.body<WishResponse>()
            return Result.success(response)

        }catch (e : Throwable){
            return Result.failure(Throwable("error in the Add Wish"))

        }
    }

    override suspend fun removeFromWish(productId: String): Result<WishResponse> {
        try {
            val request = httpClient.delete ("$url/$productId")
            val response = request.body<WishResponse>()
            return Result.success(response)

        }catch (e : Throwable){
            return Result.failure(Throwable("error in the remove Wish"))

        }
    }
}