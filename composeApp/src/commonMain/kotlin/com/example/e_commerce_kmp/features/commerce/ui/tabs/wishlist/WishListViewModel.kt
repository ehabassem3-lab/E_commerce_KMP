package com.example.e_commerce_kmp.features.commerce.ui.tabs.wishlist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.commerce.domain.repositories.WishRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class WishListViewModel( val repository: WishRepository) : ViewModel() {
         val state : MutableStateFlow<WishListStates> = MutableStateFlow(WishListStates())

    fun doAction(event: WishListEvents){
        when(event){
            is WishListEvents.AddWshList -> addWish(event.productId)
            is WishListEvents.DeleteWshList -> deleteWish(event.productId)
            WishListEvents.GetWishList -> getWish()
        }

    }

    private fun addWish(productId: String) {
        viewModelScope.launch {
            state.value = state.value.copy(addToWishApiState = Resources.Loading)
            val response = repository.addWish(productId)
            if (response.isSuccess){
                val wish = response.getOrNull()
                state.value = state.value.copy(
                    addToWishApiState = Resources.Success(wish) ,
                    wishApiState = Resources.Success(wish)

                )

            }else{
                state.value = state.value.copy(addToWishApiState = Resources.Error(Throwable("")))

            }
        }
    }
    private fun deleteWish(productId: String) {
        viewModelScope.launch {
            state.value = state.value.copy(removeFromWishApiState = Resources.Loading)
            val response = repository.removeWish(productId)
            if (response.isSuccess){
                val wish = response.getOrNull()
                state.value = state.value.copy(
                    removeFromWishApiState = Resources.Success(wish) ,
                    wishApiState = Resources.Success(wish)
                )


            }else{
                state.value = state.value.copy(removeFromWishApiState = Resources.Error(Throwable("")))

            }
        }
    }
    private fun getWish() {
        viewModelScope.launch {
            state.value = state.value.copy(wishApiState = Resources.Loading)
            val request = repository.getWishList()
            if (request.isSuccess){
                val wish = request.getOrNull()
                state.value =state.value.copy(wishApiState = Resources.Success(wish))
            }else{
                state.value = state.value.copy(wishApiState = Resources.Error(Throwable("")))
            }
        }
    }
}
