package com.example.e_commerce_kmp.features.routes

import com.example.e_commerce_kmp.features.commerce.domain.entities.Category
import com.example.e_commerce_kmp.features.commerce.domain.entities.Product
import kotlinx.serialization.Serializable

sealed class AppRoutes {
    @Serializable
    object Cart
    @Serializable
    object Login
@Serializable
object SearchRoute
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
    data class ProductsDetailsRoute(
        val sold: Int? = null,
        val images: List<String?>? = null,
        val quantity: Int? = null,
        val availableColors: List<String?>? = null,
        val imageCover: String? = null,
        val description: String? = null,
        val title: String? = null,
        val ratingsQuantity: Double? = null,
        val ratingsAverage: Double? = null,
        val price: Double? = null,
        val id: String? = null,
        val priceAfterDiscount: Double? = null
    )

    @Serializable
    data class ProductsScreen(val categoryId: String  , val subCategoryId  : String )
}
