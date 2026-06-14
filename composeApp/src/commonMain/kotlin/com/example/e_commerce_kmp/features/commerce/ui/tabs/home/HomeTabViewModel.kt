package com.example.e_commerce_kmp.features.commerce.ui.tabs.home

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.commerce.domain.entities.Category
import com.example.e_commerce_kmp.features.commerce.usecases.GetCategoriesUseCase
import com.example.e_commerce_kmp.features.commerce.usecases.GetProductsUseCase
import com.example.e_commerce_kmp.features.commerce.usecases.GetSubCategoryUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeTabViewModel  (
    private val getCategoriesUseCase: GetCategoriesUseCase ,
    private val getProductsUseCase: GetProductsUseCase ,
     private  val getSubCategoryUseCase: GetSubCategoryUseCase
): ViewModel(){
    companion object{
        val selectedIndex : MutableIntState = mutableIntStateOf(0)
        fun navigator(index : Int){
            selectedIndex.value = index
        }

    }
    val state  : MutableStateFlow<HomeTabStates> = MutableStateFlow(HomeTabStates())
     val selectedIndex : MutableIntState = mutableIntStateOf(0)

    fun navigator(index : Int){
        selectedIndex.value = index
    }

    fun doAction(event: HomeTabEvents){
        when(event){
            HomeTabEvents.GetCategories -> {

            }
            HomeTabEvents.GetProducts ->   {

            }
           HomeTabEvents.LoadData ->      {
                loadData()
            }

            is  HomeTabEvents.GetSubCategories -> {
                loadSubCategories(event.category)
            }
        }

    }
    fun loadSubCategories(category: Category){
           viewModelScope.launch {
               state.value = state.value.copy(subCategoriesApi = Resources.Loading)
             val result =  getSubCategoryUseCase.invoke(category.id?:"")
               if (result.isSuccess){
                   state.value = state.value.copy(subCategoriesApi = Resources.Success(result.getOrNull()))

               }else{
                   state.value = state.value.copy(subCategoriesApi = Resources.Error(
                       Throwable("Error While Getting the sub categories")
                   ))

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


            val categoriesState = categoriesResult.fold(
                onSuccess = { Resources.Success(it) },
                onFailure = { Resources.Error(it) }
            )
            val productsState = productsResult.fold(
                onSuccess = { Resources.Success(it) },
                onFailure = { Resources.Error(it) }
            )


            state.value = state.value.copy(
                categoriesApi =categoriesState,
                productsApi =productsState
            )
        }


    }


}