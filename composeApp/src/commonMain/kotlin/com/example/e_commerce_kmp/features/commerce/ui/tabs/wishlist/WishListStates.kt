package com.example.e_commerce_kmp.features.commerce.ui.tabs.wishlist

import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.commerce.domain.entities.Cart
import com.example.e_commerce_kmp.features.network.response.wish.WishResponse

data class WishListStates(
    val wishApiState : Resources<WishResponse> = Resources.idle,
    val addToWishApiState : Resources<WishResponse> = Resources.idle,
    val removeFromWishApiState : Resources<WishResponse> = Resources.idle,
    val latestCart : WishResponse? = null
)

sealed class WishListEvents{
    object  GetWishList : WishListEvents()
    data class AddWshList( val productId : String) : WishListEvents()
    data class DeleteWshList( val productId : String) : WishListEvents()

}
