package com.example.e_commerce_kmp.features.commerce.ui.tabs.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.commerce.usecases.GetCategoriesUseCase
import com.example.e_commerce_kmp.features.commerce.usecases.GetProductsUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeTabViewModel  (
    private val getCategoriesUseCase: GetCategoriesUseCase ,
    private val getProductsUseCase: GetProductsUseCase
): ViewModel(){
    val state  : MutableStateFlow<HomeTabStates> = MutableStateFlow(HomeTabStates())


    fun doAction(event: HomeTabEvents){
        when(event){
            HomeTabEvents.GetCategories -> {

            }
            HomeTabEvents.GetProducts ->   {

            }
            HomeTabEvents.LoadData ->      {
                loadData()
            }
        }

    }
    private fun loadData(){
        state.value = state.value.copy(categoriesApi = Resources.Loading , productsApi = Resources.Loading)
        viewModelScope.launch {
            val categoriesRequest  = async {
                getCategoriesUseCase.invoke()
            }
            val productsRequest  = async {
             getProductsUseCase.invoke()
            }
           val categoriesResult =  categoriesRequest.await()
            val productsResult  = productsRequest.await()

            println(categoriesResult)
            println("Speraaaaaaaaaaaaaaaaaaaaaate")
            println(productsResult)



        }


    }


}