package com.example.e_commerce_kmp.features.commerce.ui.tabs.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.commerce.ui.tabs.categories.CategoriesScreen
import com.example.e_commerce_kmp.features.network.httpClient
import com.example.e_commerce_kmp.features.network.response.home.categories_response.CategoriesResponse
import com.example.e_commerce_kmp.features.network.response.home.categories_response.RemoteCategory
import com.example.e_commerce_kmp.features.routes.AppRoutes
import com.example.e_commerce_kmp.features.thenes.Primary
import com.example.e_commerce_kmp.features.utilities.CustomButton
import com.example.e_commerce_kmp.features.utilities.CustomTextField
import com.example.e_commerce_kmp.features.utilities.ImageCarousel
import com.example.e_commerce_kmp.ic_cart
import com.example.e_commerce_kmp.ic_curisol
import com.example.e_commerce_kmp.ic_logo_route_small
import com.example.promobanner.PromoCarousel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.isSuccess
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    navController: NavController,
){
    val viewModel = koinViewModel<HomeTabViewModel>()
    val state = viewModel.state.collectAsState()
    LaunchedEffect(Unit){
        viewModel.doAction(HomeTabEvents.LoadData)

    }
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 10.dp , end = 10.dp , top = 60.dp, bottom = 100.dp)
    ){
        item {
            Box(
            modifier = Modifier.size(60.dp)
        ){
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(Res.drawable.ic_logo_route_small) ,
                contentDescription = ""

            )
            }
        }
        item {

            Column (
                modifier =
                    Modifier
                        .fillMaxSize() ,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                HomeTabSearchBar(navController)
                PromoCarousel()
                CategoriesSection(state.value.categoriesApi){
            viewModel.navigator(1)
                }
                ProductsSection(state.value.productsApi)
            }

        }







    }

}