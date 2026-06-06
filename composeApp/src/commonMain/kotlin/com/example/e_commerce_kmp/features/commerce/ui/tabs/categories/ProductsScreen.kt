package com.example.e_commerce_kmp.features.commerce.ui.tabs.categories

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.commerce.domain.entities.Category
import com.example.e_commerce_kmp.features.commerce.domain.entities.Product
import com.example.e_commerce_kmp.features.commerce.ui.tabs.home.HomeTabSearchBar
import com.example.e_commerce_kmp.features.commerce.ui.tabs.home.ProductItem
import com.example.e_commerce_kmp.features.thenes.Primary
import com.example.e_commerce_kmp.features.utilities.ErrorView
import com.example.e_commerce_kmp.features.utilities.ShimmerCategoryItem
import com.example.e_commerce_kmp.ic_logo_route_small
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProductScreen(
    navController: NavController ,
    categoryId: String ,
    subCategoryId: String
){

    val viewModel = koinViewModel<ProductsScreenViewModel>()
    val state = viewModel.state.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.onEvent(ProductsEvents.LoadProducts)
    }
    Column (
        modifier = Modifier
          .fillMaxSize()
             ,
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        when(val state = state.value.productApiState){
            is Resources.Error -> ErrorView {  }
            Resources.Loading -> ShimmerCategoryItem(isHorizonal = false)
            is Resources.Success<List<Product>> -> {
                val productsList = state.data ?: emptyList()
                println(productsList)
                println("Products count = ${productsList.size}")
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2) ,
                    userScrollEnabled = true,
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ){
                    items(productsList){ product->
                        ProductItem(
                            product,
                            onProductClick = {  },
                            onAddClick = { },
                            onWishClick = {}
                        )

                    }



                }
            }
            Resources.idle -> {
            }
        }





    }


}