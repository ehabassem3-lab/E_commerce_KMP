package com.example.e_commerce_kmp.features.commerce.ui.tabs.home

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.commerce.domain.entities.Product
import com.example.e_commerce_kmp.features.utilities.ErrorView

@Composable
fun ProductsSection(
    productApiState : Resources<List<Product>>
) {
    when(productApiState){
        is Resources.Error -> ErrorView {  }
        Resources.Loading -> CircularProgressIndicator()
        is Resources.Success<*> -> {

        }
        Resources.idle -> TODO()
    }
}



