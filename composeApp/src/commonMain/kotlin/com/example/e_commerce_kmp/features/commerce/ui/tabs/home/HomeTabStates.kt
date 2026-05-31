package com.example.e_commerce_kmp.features.commerce.ui.tabs.home

import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.commerce.domain.entities.Category
import com.example.e_commerce_kmp.features.commerce.domain.entities.Product

data class HomeTabStates
    (
    val categoriesApi : Resources<List<Category>> = Resources.Loading,
    val productsApi : Resources<List<Product>> = Resources.Loading
   )
sealed class HomeTabEvents{
    object LoadData : HomeTabEvents()
    object GetCategories : HomeTabEvents()
     object  GetProducts : HomeTabEvents()
}