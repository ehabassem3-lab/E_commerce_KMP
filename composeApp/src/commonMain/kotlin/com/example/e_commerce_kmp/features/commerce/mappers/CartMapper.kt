package com.example.e_commerce_kmp.features.commerce.mappers

import androidx.compose.material3.Card
import androidx.compose.runtime.mutableStateOf
import com.example.e_commerce_kmp.features.commerce.domain.entities.Cart
import com.example.e_commerce_kmp.features.commerce.domain.entities.Product
import com.example.e_commerce_kmp.features.network.response.cart.RemoteCart
import kotlin.collections.forEach

fun RemoteCart.toCart(): Cart {
    val entries = mutableMapOf<String, Product>()

    products?.forEach { item ->

        val baseProduct = item?.product?.toProduct()!!

        val product = baseProduct.copy(
            cartQuantity = item.count ?: 0,
            price = item.price?.toDouble() ?: 0.0,
            priceAfterDiscount = item.price?.toDouble() ?: 0.0
        )

        entries[product.id ?:""] = product
    }

    return Cart(
        product = entries,
        totalPrice = totalCartPrice ?: 0.0
    )
}

