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

    override suspend fun getCategories(category: String?): Result<List<Category>> {
        return try {
            val result = remoteDataSource.getCategories()
            val categoryResponse = result.getOrNull()
                ?: return Result.failure(Throwable("Categories response is null"))

            val categories = categoryResponse.categories?.map { it.toCategory() } ?: emptyList()
            Result.success(categories)
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }

    override suspend fun getProducts(
        category: String?,
        subCategory: String?
    ): Result<List<Product>> {
        return try {
            val result = remoteDataSource.getProducts(category, subCategory)
            val productResponse = result.getOrNull()
                ?: return Result.failure(Throwable("Products response is null"))

            val products = productResponse.products?.map { it.toProduct() } ?: emptyList()
            Result.success(products)
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }

    override suspend fun getSubCategories(category: String): Result<List<Category>> {
        return try {
            val result = remoteDataSource.getSubCategories(category)
            val categoryResponse = result.getOrNull()
                ?: return Result.failure(Throwable("SubCategories response is null"))

            val categories = categoryResponse.categories?.map { it.toCategory() } ?: emptyList()
            Result.success(categories)
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}