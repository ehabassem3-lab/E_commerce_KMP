package com.example.e_commerce_kmp.features.routes

import com.example.e_commerce_kmp.features.commerce.domain.entities.Category
import kotlinx.serialization.Serializable

sealed class AppRoutes {
    @Serializable
    object Login
    @Serializable
     object  Register
    @Serializable
    object  MainScreen
    @Serializable
    object Splash
    @Serializable
    object ForgetPassWord
    @Serializable
    object  ResetPassWord
    @Serializable
    data class ProductsScreen(val categoryId: String  , val subCategoryId  : String )
}
