package com.example.e_commerce_kmp.features.commerce.ui.tabs.categories

import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.commerce.domain.entities.Product

data  class ProductsState (val productApiState  : Resources<List<Product>> = Resources.idle)

sealed class ProductsEvents {

    object LoadProducts : ProductsEvents()
}
