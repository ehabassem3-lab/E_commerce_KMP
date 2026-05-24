package com.example.e_commerce_kmp.features.commerce.data.home_repository.repositories

import com.example.e_commerce_kmp.features.commerce.data.home_repository.remote_data_source.HomeRemoteDataSource
import com.example.e_commerce_kmp.features.commerce.domain.entities.Category
import com.example.e_commerce_kmp.features.commerce.domain.entities.Product
import com.example.e_commerce_kmp.features.commerce.domain.repositories.HomeRepository
import com.example.e_commerce_kmp.features.commerce.mappers.toCategory
import com.example.e_commerce_kmp.features.network.response.home.categories_response.CategoriesResponse
import com.example.e_commerce_kmp.features.network.response.home.products_response.ProductsResponse
import kotlin.collections.map
import com.example.e_commerce_kmp.features.commerce.mappers.toProduct
import kotlin.collections.emptyList

class HomeRepositoriesImpl(private val remoteDataSource: HomeRemoteDataSource) : HomeRepository {
    override suspend  fun  getCategories(category: String): Result<List<Category>> {
        try {
            val result = remoteDataSource.getCategories()
            if (result.isSuccess) {
                val categoryResponse: CategoriesResponse = result.getOrNull()!!
               val categories = categoryResponse.categories.map { remoteCategory ->
                    return@map remoteCategory.toCategory()

                } ?:emptyList()
                return Result.success(categories)
            }
            else{
                return Result.failure(Throwable("Categories Error "))
            }
        } catch (t: Throwable) {
            return Result.failure(t)
        }
    }

    override suspend  fun getProducts(
        category: String?,
        subCategory: String?
    ): Result<List<Product>> {
        try {
            val result= remoteDataSource.getProducts(category , subCategory)
            if (result.isSuccess && result.getOrNull() != null) {
                val productResponse : ProductsResponse = result.getOrNull()!!
                val products = productResponse.products.mapNotNull {
                   return@mapNotNull  it.toProduct()
                }
               return Result.success(products)
            }
            else{
                return Result.failure(Throwable("Products Error "))

            }


        }catch (t : Throwable){
            return Result.failure(t)

        }

    }

    override suspend  fun getSubCategories(category: String): Result<List<Category>> {
        try {
            val result = remoteDataSource.getSubCategories(category)
            if (result.isSuccess) {
                val categoryResponse: CategoriesResponse = result.getOrNull()!!
                val categories = categoryResponse.categories.map { remoteCategory ->
                    return@map remoteCategory.toCategory()

                }?:emptyList()
                return Result.success(categories)
            }
            else{
                return Result.failure(Throwable("Categories Error "))
            }
        } catch (t: Throwable) {
            return Result.failure(t)
        }
    }
}