package com.example.e_commerce_kmp.features.commerce.usecases

import com.example.e_commerce_kmp.features.commerce.domain.entities.Category
import com.example.e_commerce_kmp.features.commerce.domain.entities.Product
import com.example.e_commerce_kmp.features.commerce.domain.repositories.HomeRepository

class GetProductsUseCase(private val homeRepository: HomeRepository) {
        suspend    fun invoke(category: String , sunCategory : String) : Result<List<Product>>{
            return homeRepository.getProducts(category  , sunCategory)

    }
}