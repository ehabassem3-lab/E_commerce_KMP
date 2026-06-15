package com.example.e_commerce_kmp.features.commerce.ui.tabs.wishlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.commerce.ui.Cart.CartProductItem
import com.example.e_commerce_kmp.features.commerce.ui.tabs.home.HomeTabSearchBar
import com.example.e_commerce_kmp.features.network.response.wish.RemoteWish
import com.example.e_commerce_kmp.features.network.response.wish.WishResponse
import com.example.e_commerce_kmp.features.thenes.Primary
import com.example.e_commerce_kmp.ic_logo_route_small
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun WishListScreen(navController: NavController){
    val viewModel = koinInject<WishListViewModel>()
    val state = viewModel.state.collectAsState()

    LaunchedEffect(Unit){
        viewModel.doAction(WishListEvents.GetWishList)
    }
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
            when (state.value.wishApiState) {
                is Resources.Error -> {}
                Resources.Loading -> CircularProgressIndicator()
                is Resources.Success<WishResponse> ->{
                    val wish = (state.value.wishApiState as Resources.Success<WishResponse>).data
                    val wishList = wish?.data ?: emptyList()
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(1),
                        modifier = Modifier.fillMaxWidth() ,
                        verticalArrangement = Arrangement.spacedBy(10.dp) ,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(wishList){
                            CartProductItem(
                                remmoteWish = it,
                                onProductClick = {}
                            )

                        }
                    }
                }
                Resources.idle -> TODO()
            }
        }
    }

}