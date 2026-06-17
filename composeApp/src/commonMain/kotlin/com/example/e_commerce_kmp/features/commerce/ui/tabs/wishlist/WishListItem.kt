package com.example.e_commerce_kmp.features.commerce.ui.tabs.wishlist

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.commerce.ui.Cart.CartEvents
import com.example.e_commerce_kmp.features.commerce.ui.Cart.CartViewModel
import com.example.e_commerce_kmp.features.network.response.wish.RemoteWish
import com.example.e_commerce_kmp.features.thenes.AppTypography
import com.example.e_commerce_kmp.features.thenes.DarkPrimary
import com.example.e_commerce_kmp.features.thenes.Primary
import com.example.e_commerce_kmp.features.thenes.White
import com.example.e_commerce_kmp.ic_full_heart
import com.example.e_commerce_kmp.ic_logo_route_small
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import org.koin.dsl.module
import kotlin.collections.get
import kotlin.time.Duration.Companion.seconds

@Composable
fun WishListItem(
    remmoteWish : RemoteWish? = null ,
    onProductClick : () -> Unit

) {
    val cartViewModel = koinInject <CartViewModel>()
    val state = cartViewModel.state.collectAsState()
    val latestProduct = state.value.latestCart?.product?.get(remmoteWish?.id)
    val isInCart = latestProduct != null
    val wishListViewModel = koinInject<WishListViewModel>()
    val wishState = wishListViewModel.state.collectAsState()
    val wishList = (wishState.value.wishApiState as? Resources.Success)?.data?.data ?: emptyList()


    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .border( width = 1.dp  , shape =  RoundedCornerShape(20.dp),  color = DarkPrimary)
    ){
        AsyncImage(
            modifier = Modifier.fillMaxHeight().width(130.dp) .border( width = 1.dp  , shape =  RoundedCornerShape(20.dp),  color = DarkPrimary)
            ,
            contentScale = ContentScale.FillBounds ,
            model = remmoteWish?.imageCover ,
            error =painterResource( Res.drawable.ic_logo_route_small ),
            contentDescription = ""

        )
        Spacer(modifier = Modifier.size(8.dp))

            Column  (
                modifier = Modifier.fillMaxHeight().width(130.dp)  ,
                 verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    remmoteWish?.title ?:""
                    , style =  AppTypography.bodyMedium.copy(color = DarkPrimary , fontSize = 20.sp) ,
                    modifier = Modifier.height(70.dp).clickable{
                        onProductClick()
                    }
                )
                Text("Price : ${remmoteWish?.price.toString() ?:""}" , style =  AppTypography.bodyMedium.copy(color = DarkPrimary , fontSize = 20.sp))

            }
            Column (
                modifier = Modifier.fillMaxHeight().width(130.dp) ,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Row (
                    modifier = Modifier
                        .size(44.dp)
                        .shadow(
                            elevation = 4.dp,
                            shape = CircleShape ,
                        )
                        .clip(CircleShape)
                        .background(White)
                        .align(Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically ,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.ic_full_heart),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                            .clickable {
                                wishListViewModel.doAction(
                                    WishListEvents.DeleteWshList(remmoteWish?.id ?: "")
                                )
                            }
                    )
                }

                Row (
                    modifier =
                        Modifier
                            .width(100.dp)
                            .height(40.dp)
                            .background(Primary , shape = RoundedCornerShape(35.dp))
                            .clickable{
                                cartViewModel.doAction(CartEvents.AddProduct(remmoteWish?.id?:""))
                            } ,
                    verticalAlignment = Alignment.CenterVertically ,
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(
                        "Add To Cart" ,
                        style = AppTypography.bodyMedium.copy(color = Color.White, fontSize = 15.sp)
                    )

                }




        }



    }
}