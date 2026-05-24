package com.example.e_commerce_kmp.features.commerce.data.home_repository.remote_data_source

import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.network.response.home.categories_response.CategoriesResponse
import com.example.e_commerce_kmp.features.network.response.home.categories_response.RemoteCategory
import com.example.e_commerce_kmp.features.network.response.home.products_response.ProductsResponse

interface HomeRemoteDataSource {
   suspend fun getCategories() : Result<CategoriesResponse>
    suspend  fun getProducts(category: String? , sunCategory: String?) : Result<ProductsResponse>
    suspend fun getSubCategories( category: String) : Result<CategoriesResponse>
}