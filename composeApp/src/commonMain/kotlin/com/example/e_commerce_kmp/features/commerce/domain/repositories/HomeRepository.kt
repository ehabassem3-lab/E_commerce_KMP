package com.example.e_commerce_kmp.features.commerce.domain.repositories

import com.example.e_commerce_kmp.features.commerce.domain.entities.Category
import com.example.e_commerce_kmp.features.commerce.domain.entities.Product

interface HomeRepository {
    suspend fun  getCategories(category: String): Result<List<Category>>
    suspend fun getProducts( category: String? , subCategory: String?) : Result<List<Product>>
    suspend fun getSubCategories(category: String) : Result<List<Category>>
}