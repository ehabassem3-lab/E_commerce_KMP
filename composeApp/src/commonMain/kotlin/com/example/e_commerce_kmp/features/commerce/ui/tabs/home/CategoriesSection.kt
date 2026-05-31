package com.example.e_commerce_kmp.features.commerce.ui.tabs.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.e_commerce_kmp.features.commerce.domain.entities.Product
import com.example.e_commerce_kmp.features.thenes.AppTypography
import com.example.e_commerce_kmp.features.thenes.Primary
import org.jetbrains.compose.resources.DrawableResource

@Composable
fun CategoriesSection (
    navController: NavController
){
    Column (
        modifier = Modifier.fillMaxWidth(.95f).height(330.dp) ,
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier.fillMaxWidth().height(25.dp) ,
              horizontalArrangement = Arrangement.SpaceBetween
             ) {
            Text(
                "Categories",
                style = AppTypography.titleLarge.copy(color = Primary) ,
                modifier = Modifier.clickable{

                }


            )

            Text(
                "View All " ,
                style = AppTypography.labelLarge.copy(color = Primary) ,
                modifier = Modifier.clickable{

                }
            )

        }
        Spacer(modifier = Modifier.size(10.dp))
        LazyHorizontalGrid(
            rows = GridCells.Fixed(2) ,
            modifier = Modifier.fillMaxSize().background(Primary)
        ){

        }
    }


}

