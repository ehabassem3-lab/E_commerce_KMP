package com.example.e_commerce_kmp.features.commerce.usecases

import com.example.e_commerce_kmp.features.commerce.domain.entities.Category
import com.example.e_commerce_kmp.features.commerce.domain.repositories.HomeRepository

class GetSubCategoryUseCase(private val homeRepository: HomeRepository) {
    suspend fun invoke(category: String): Result<List<Category>>{
           return homeRepository.getSubCategories(category)
    }

}