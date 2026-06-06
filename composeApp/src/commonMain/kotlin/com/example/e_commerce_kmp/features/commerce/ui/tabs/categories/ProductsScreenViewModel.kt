package com.example.e_commerce_kmp.features.commerce.ui.tabs.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.commerce.usecases.GetProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ProductsScreenViewModel (
     val getProductsUseCase: GetProductsUseCase
) : ViewModel () {
     val state : MutableStateFlow<ProductsState> = MutableStateFlow(ProductsState())

    fun onEvent(events: ProductsEvents){
        when(events){
            ProductsEvents.LoadProducts -> {
                loadProducts()
            }
        }

    }

    private fun loadProducts() {
         state.value  = state.value.copy(productApiState = Resources.Loading)
        viewModelScope.launch {
         val result  =    getProductsUseCase.invoke()
            if(result.isSuccess){
                state.value  = state.value.copy(productApiState = Resources.Success(result.getOrNull()))
            }else{
                state.value  = state.value.copy(productApiState = Resources.Error(
                    Throwable("Error While Loading The Products")
                ))
            }

        }
    }

}