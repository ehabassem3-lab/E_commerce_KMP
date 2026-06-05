package com.example.e_commerce_kmp.features.commerce.ui.tabs.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.commerce.domain.entities.Product
import com.example.e_commerce_kmp.features.utilities.ErrorView
import com.example.e_commerce_kmp.features.utilities.ShimmerCategoryItem

@Composable
fun ProductsSection(
    productApiState : Resources<List<Product>>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(.95f)
            .height(3000.dp),

        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        when (productApiState) {
            is Resources.Error -> ErrorView { }
            Resources.Loading ->  ShimmerCategoryItem(isHorizonal =  false)

            is Resources.Success<List<Product>> -> {
                val products = productApiState.data ?: emptyList()
                LazyVerticalGrid(
                    userScrollEnabled = true,
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    items(products) { product ->
                        ProductItem(
                            productImage = product.imageCover ?: "",
                            productTitle = product.title ?: "",
                            priceBefore = product.price ?: 0.0,
                            priceAfter = product.priceAfterDiscount ?: 0.0,
                            rating = product.ratingsAverage ?: 0.0,
                            onProductClick = {

                            },
                            onAddClick = {

                            },
                            onWishClick = {

                            }
                        )
                    }
                }

            }

            Resources.idle -> {}
        }
    }
}



