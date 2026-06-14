package com.example.e_commerce_kmp.features.commerce.ui.Cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.commerce.domain.entities.Cart
import com.example.e_commerce_kmp.features.commerce.domain.entities.Product
import com.example.e_commerce_kmp.features.commerce.domain.repositories.CartRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CartViewModel (private  val cartRepository: CartRepository) : ViewModel() {
  val state : MutableStateFlow<CartState> = MutableStateFlow(CartState())


    fun doAction(event : CartEvents){
        when(event){
            is CartEvents.AddProduct ->{ addProduct(event.productId)}
            is CartEvents.DeleteProduct -> { deleteProduct(event.productId)}
            CartEvents.GetCart ->  getCart()
            is CartEvents.UpdateCart -> {
                updateCart(event.productId, event.quantity)
            }
        }

    }

    private fun getCart() {
        viewModelScope.launch{
            state.value = state.value.copy(cartApiState = Resources.Loading)
            val response = cartRepository.getCart()
            if (response.isSuccess){
              val cart = response.getOrNull()
             state.value = state.value.copy(
                 cartApiState = Resources.Success(cart) ,
                 latestCart = cart

             )
            }else{
                state.value = state.value.copy(
                    cartApiState = Resources.Error(response.exceptionOrNull()!!) ,

                )
            }


        }
    }

    private fun updateCart(productId: String, quantity: Int) {
       viewModelScope.launch {
           state.value = state.value.copy(updateCartApiState = Resources.Loading)
           val response = cartRepository.updateCart(productId,quantity)
           if (response.isSuccess){
               val cart = response.getOrNull()
               state.value = state.value.copy(updateCartApiState = Resources.Success(cart)
               , latestCart =  cart
               )
           }else{
               state.value = state.value.copy(  cartApiState = Resources.Error(response.exceptionOrNull()!!) ,)
           }
       }
    }

    private fun deleteProduct(productId: String)  {
     viewModelScope.launch {
         state.value = state.value.copy(removeFromCartApiState = Resources.Loading)
         val response = cartRepository.deleteProduct(productId)
         if (response.isSuccess){
             val cart = response.getOrNull()
             state.value =state.value.copy(
                 removeFromCartApiState = Resources.Success(cart)
                 , latestCart =  cart
             )

         }else{
             state.value = state.value.copy(removeFromCartApiState = Resources.Error(response.exceptionOrNull()!!))
         }

     }
    }

    private fun addProduct(productId: String)  {
      viewModelScope.launch {
          state.value = state.value.copy(addToCartApiState = Resources.Loading)
          val response = cartRepository.addProductToCart(productId)
          if (response.isSuccess){
              val cart = response.getOrNull()
              println(cart)
              state.value = state.value.copy(addToCartApiState = Resources.Success(cart) , latestCart = cart)
          }else{
              state.value = state.value.copy(addToCartApiState = Resources.Error(response.exceptionOrNull()!!))
          }
      }
    }

}