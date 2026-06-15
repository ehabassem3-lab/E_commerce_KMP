package com.example.e_commerce_kmp.features.commerce.data.wishl_list
import com.example.e_commerce_kmp.features.commerce.domain.repositories.WishRepository
import com.example.e_commerce_kmp.features.network.response.wish.WishResponse

class WishRepositoryImpl(val dataSource: WishListDataSource) : WishRepository {
    override suspend fun getWishList(): Result<WishResponse> {
         val request =  dataSource.getUserWishList()
        val response = request.getOrNull()
        return if (request.isSuccess && response != null){
            Result.success(response )

        }else{
           Result.failure(Throwable("Error in the get wish in repo"))
       }
    }

    override suspend fun addWish(productId: String): Result<WishResponse> {
        val request = dataSource.addWishToList(productId)
        val response = request.getOrNull()
        return  if (request.isSuccess && response != null){
            Result.success(response)
        }else{
            Result.failure(Throwable("Error in the add wish in repo"))
        }
    }

    override suspend fun removeWish(productId: String): Result<WishResponse> {
        val request = dataSource.removeFromWish(productId)
        val response = request.getOrNull()
        return  if (request.isSuccess && response != null){
            Result.success(response)
        }else{
            Result.failure(Throwable("Error in the delte wish in repo"))

        }
    }
}