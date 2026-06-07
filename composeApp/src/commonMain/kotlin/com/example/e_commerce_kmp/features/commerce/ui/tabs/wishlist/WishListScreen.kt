package com.example.e_commerce_kmp.features.commerce.ui.tabs.wishlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.commerce.ui.tabs.home.HomeTabSearchBar
import com.example.e_commerce_kmp.features.thenes.Primary
import com.example.e_commerce_kmp.ic_logo_route_small
import org.jetbrains.compose.resources.painterResource

@Composable
fun WishListScreen(navController: NavController){
    Column (
        modifier =
            Modifier
                .fillMaxSize()
                .background(Color.White)
            .padding(start = 10.dp , end = 10.dp , top = 60.dp, bottom = 100.dp)
    ){
        Box(
            modifier = Modifier.size(60.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(Res.drawable.ic_logo_route_small),
                contentDescription = ""

            )
        }
        HomeTabSearchBar(navController)
        Spacer(modifier = Modifier.size(40.dp))
        Column (modifier = Modifier.fillMaxSize()){

        }
    }

}