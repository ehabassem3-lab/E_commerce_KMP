package com.example.e_commerce_kmp.features.commerce.ui.Cart

import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.commerce.domain.entities.Cart
import com.example.e_commerce_kmp.features.commerce.domain.entities.Product
import com.example.e_commerce_kmp.features.commerce.ui.tabs.categories.ProductsEvents

data class CartState(
    val cartApiState : Resources<Cart> = Resources.idle ,
    val addToCartApiState : Resources<Cart> = Resources.idle,
    val removeFromCartApiState : Resources<Cart> = Resources.idle,
    val updateCartApiState : Resources<Cart> = Resources.idle ,
    val latestCart : Cart? = null
)

sealed   class CartEvents{
    object  GetCart: CartEvents()
    data class  AddProduct(val productId: String): CartEvents()
    data class DeleteProduct( val productId: String): CartEvents()
    data class  UpdateCart(val productId: String , val quantity : Int): CartEvents()

}


