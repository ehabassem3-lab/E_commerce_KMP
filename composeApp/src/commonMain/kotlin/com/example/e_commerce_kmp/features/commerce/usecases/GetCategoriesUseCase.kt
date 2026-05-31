package com.example.e_commerce_kmp.features.commerce.usecases

import com.example.e_commerce_kmp.features.commerce.domain.entities.Category
import com.example.e_commerce_kmp.features.commerce.domain.repositories.HomeRepository

class GetCategoriesUseCase(private val homeRepository: HomeRepository) {
    suspend    fun  invoke() : Result<List<Category>>{
        return homeRepository.getCategories()
    }
}