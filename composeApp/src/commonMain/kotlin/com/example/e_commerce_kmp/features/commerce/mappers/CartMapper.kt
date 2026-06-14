package com.example.e_commerce_kmp.features.commerce.mappers

import androidx.compose.material3.Card
import androidx.compose.runtime.mutableStateOf
import com.example.e_commerce_kmp.features.commerce.domain.entities.Cart
import com.example.e_commerce_kmp.features.commerce.domain.entities.Product
import com.example.e_commerce_kmp.features.network.response.cart.RemoteCart
import kotlin.collections.forEach

fun RemoteCart.toCart(): Cart {
    val entries = mutableMapOf<String, Product>()
    products?.forEach {
        var product = it?.product?.toProduct()!!
        product.cartQuantity = it.count ?: 0
        entries[it?.product?.id?:""] = product
    }
    return Cart(
        product = entries,
        totalPrice = totalCartPrice?:0.0
    )
}


