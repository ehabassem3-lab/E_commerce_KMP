package com.example.e_commerce_kmp.features.commerce.data.home_repository.remote_data_source

import androidx.compose.ui.geometry.Rect
import com.example.e_commerce_kmp.features.network.response.home.categories_response.CategoriesResponse
import com.example.e_commerce_kmp.features.network.response.home.products_response.ProductsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.isSuccess

class HomeRemoteDataSourceImpl (private  val httpClient: HttpClient) : HomeRemoteDataSource {
    override suspend fun getCategories(): Result<CategoriesResponse> {

      return  try {
            val response = httpClient.get("v1/categories")
            val category = response.body<CategoriesResponse>()
            if(response.status.isSuccess()){
                 Result.success(category)
            } else{
                return Result.failure(
                    Throwable("SomeThing Went Wrong in Retriving The Categories  ")
                )
            }
        }
        catch (t : Throwable){
              Result.failure(t)
        }

    }

    override suspend fun getProducts(
        category: String?,
        sunCategory: String?
    ): Result<ProductsResponse> {
        var url = "v1/products"
        if(category != null && sunCategory != null){
             url +="?category=$category&category=$sunCategory"
        }

        return try {
            val response = httpClient.get(url)
            val products = response.body<ProductsResponse>()
            if (response.status.isSuccess()){
                Result.success(products)
            }else{
                Result.failure(Throwable("Error While Getting The Products"))
            }
        } catch (t : Throwable){
            Result.failure(t)

        }



    }

    override suspend fun getSubCategories(category: String): Result<CategoriesResponse> {
        return try {
            val response = httpClient.get("v1/categories/${category}/subcategories")
            val subCategory = response.body<CategoriesResponse>()
            if (response.status.isSuccess()){
                Result.success(subCategory)
            }else{
                Result.failure(Throwable("Error While Retriving the subCategories"))
            }
        }catch (t : Throwable){
            Result.failure(t)
        }
    }


}