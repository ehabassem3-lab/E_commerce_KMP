package com.example.e_commerce_kmp.features.commerce.ui.Cart

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.PageSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.commerce.domain.entities.Cart
import com.example.e_commerce_kmp.features.commerce.domain.entities.Product
import com.example.e_commerce_kmp.features.commerce.ui.tabs.home.ProductItem
import com.example.e_commerce_kmp.features.routes.AppRoutes
import com.example.e_commerce_kmp.features.thenes.AppTypography
import com.example.e_commerce_kmp.features.thenes.DarkPrimary
import com.example.e_commerce_kmp.ic_arrow_back
import com.example.e_commerce_kmp.ic_cart
import com.example.e_commerce_kmp.ic_search
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CartScreen(navController: NavController){

    val cartViewModel = koinInject <CartViewModel>()
    val state = cartViewModel.state.collectAsState()
    Column (
        modifier =
            Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(start = 10.dp , end = 10.dp , top = 60.dp, bottom = 100.dp)
    ){
        Row (
            modifier = Modifier.fillMaxWidth().height(30.dp) ,
           horizontalArrangement = Arrangement.SpaceAround

        ){
            Icon(
                painter = painterResource(Res.drawable.ic_arrow_back) ,
                contentDescription = "" ,
                tint = DarkPrimary,
                modifier = Modifier.size(22.dp).clickable{
                    navController.navigate(AppRoutes.MainScreen)
                }
            )
            Text(
                "Cart" ,
                style = AppTypography.bodyMedium.copy(color = DarkPrimary, fontSize = 22.sp , fontWeight = FontWeight.Bold)
            )
            Row (
                horizontalArrangement = Arrangement.SpaceEvenly

            ){
                Icon(
                    painter = painterResource(Res.drawable.ic_search) ,
                    contentDescription = "" ,
                    tint = DarkPrimary,
                    modifier = Modifier.size(22.dp).clickable{

                    }
                )
                Spacer(modifier = Modifier.size(15.dp))

                Icon(
                    painter = painterResource(Res.drawable.ic_cart) ,
                    contentDescription = "" ,
                    tint = DarkPrimary,
                    modifier = Modifier.size(22.dp).clickable{
                    }
                )
            }



        }
        when(state.value.cartApiState){
            is Resources.Error -> {}
            Resources.Loading -> CircularProgressIndicator()
            is Resources.Success<Cart> -> {
                val cartItem = (state.value.cartApiState as Resources.Success<Cart>).data
                val productCollection = cartItem?.product?.values ?: emptyList()
                val productList: List<Product> =productCollection.toList()
                LazyVerticalGrid(
                    columns = GridCells.Fixed(1),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(productList){
                        ProductItem(
                            it,
                            onProductClick = {} ,
                            onWishClick = {  }
                        )

                    }


                }
            }
            Resources.idle ->{}
        }

    }

}

