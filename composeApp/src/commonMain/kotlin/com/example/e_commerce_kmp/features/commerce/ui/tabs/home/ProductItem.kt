package com.example.e_commerce_kmp.features.commerce.ui.tabs.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.commerce.domain.entities.Product
import com.example.e_commerce_kmp.features.commerce.ui.Cart.AddingProductsItem
import com.example.e_commerce_kmp.features.commerce.ui.Cart.CartEvents
import com.example.e_commerce_kmp.features.commerce.ui.Cart.CartViewModel
import com.example.e_commerce_kmp.features.commerce.ui.tabs.wishlist.WishListEvents
import com.example.e_commerce_kmp.features.commerce.ui.tabs.wishlist.WishListViewModel
import com.example.e_commerce_kmp.features.network.response.wish.WishResponse
import com.example.e_commerce_kmp.features.thenes.AppTypography
import com.example.e_commerce_kmp.features.thenes.Primary
import com.example.e_commerce_kmp.ic_add
import com.example.e_commerce_kmp.ic_discount_line
import com.example.e_commerce_kmp.ic_full_heart
import com.example.e_commerce_kmp.ic_heart
import com.example.e_commerce_kmp.ic_logo_route_small
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.commerce.ui.tabs.wishlist.WishListItem

@Composable
fun ProductItem(
    product: Product,
    onProductClick : () -> Unit  ,
    onWishClick : () -> Unit ,
){

    val cartViewModel = koinInject <CartViewModel>()

    val state = cartViewModel.state.collectAsState()
    val latestProduct = state.value.latestCart?.product?.get(product.id)
    val isInCart = latestProduct != null

    val wishListViewModel = koinInject<WishListViewModel>()
    val wishState = wishListViewModel.state.collectAsState()
    val wishList = (wishState.value.wishApiState as? Resources.Success)?.data?.data ?: emptyList()
    val isWishListed = wishList.any { it?.id == product.id }

    Column(
        modifier = Modifier
            .width(200.dp)
            .height(290.dp)
            .border( width = 4.dp , shape = RoundedCornerShape(20.dp ) , color = Primary.copy(alpha = .5f))
            .clickable {

            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                , contentAlignment = Alignment.Center
            ){


                AsyncImage(
                    modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.FillBounds ,
                    model = product.imageCover ,
                    contentDescription = "" ,
                    error = painterResource(Res.drawable.ic_logo_route_small )
                )
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.TopEnd)
                        .padding(top = 12.dp, end = 12.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .clickable{
                            println(wishList)
                            if (isWishListed){
                                wishListViewModel.doAction(WishListEvents.DeleteWshList(product.id?:""))
                            }else{
                                wishListViewModel.doAction(WishListEvents.AddWshList(product.id?:""))

                            }


                        } ,
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        painter =
                           if (isWishListed) painterResource(Res.drawable.ic_full_heart)
                           else  painterResource(Res.drawable.ic_heart)  ,
                        contentDescription = "" ,
                        tint =  Primary,
                        modifier = Modifier
                            .size(20.dp)


                    )
                }

            }
            Spacer(modifier = Modifier.size(8.dp))
        Column (
            modifier = Modifier.fillMaxSize().padding( 10.dp)
        ){

            Text(
                text =  product.title ?:"" ,
                style = AppTypography.bodyMedium.copy(color = Primary, fontSize = 20.sp) ,
                modifier = Modifier
                    .height(30.dp)
                    .fillMaxWidth()
                    .padding(5.dp).clickable{
                        onProductClick()
                    }
            )
            Spacer(modifier = Modifier.size(4.dp))
            Row (
                modifier = Modifier.height(28.dp).fillMaxWidth(.95f) ,
                verticalAlignment = Alignment.CenterVertically ,
                horizontalArrangement = Arrangement.Center
            ){
                Text(
                    text =  "EGP ${product.priceAfterDiscount}" ,
                    style = AppTypography.bodyMedium.copy(color = Primary, fontSize = 16.sp)  ,
                )
                Spacer(modifier = Modifier.size(22.dp))
                Box(
                    contentAlignment = Alignment.Center ,
                    modifier = Modifier.alpha(.7f).padding(5.dp)
                ){
                    Icon(
                        painter = painterResource(Res.drawable.ic_discount_line) ,
                        contentDescription = "" ,
                        modifier = Modifier.fillMaxWidth(.4f).height(10.dp)
                    )

                    Text(
                        text =  " ${product.price}  EGP" ,
                        style = AppTypography.bodyMedium.copy(color = Primary, fontSize = 16.sp)  ,
                        modifier = Modifier.fillMaxSize()

                    )
                }

            }
            Spacer(modifier = Modifier.size(5.dp))
            Row (
                modifier = Modifier.fillMaxWidth().height(90.dp) ,
                verticalAlignment = Alignment.CenterVertically ,
                horizontalArrangement = Arrangement.Center
            ){
                Text(text = "Review (${product.ratingsAverage}) ⭐"   ,
                    style = AppTypography.bodyMedium.copy(color = Primary, fontSize = 12.sp)  ,)
                Spacer(modifier = Modifier.size(5.dp))
                if (isInCart){
                    AddingProductsItem(
                        onAddClick = {
                            cartViewModel.doAction(
                                CartEvents.UpdateCart(product.id?:"" , latestProduct?.cartQuantity?.plus(1) ?: 0 )
                            )


                        } ,
                        onRemoveClick = {
                            val currentQty = latestProduct?.cartQuantity ?: 0
                            if (currentQty == 1) {
                                cartViewModel.doAction(
                                    CartEvents.DeleteProduct(product.id ?: "")
                                )
                            } else {
                                cartViewModel.doAction(
                                    CartEvents.UpdateCart(product.id?:"" , currentQty.minus(1))
                                )
                            }

                        } ,
                        text =  (latestProduct?.cartQuantity ?: 0).toString()
                    )
                }else{
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(Primary)
                            .clickable {
                                cartViewModel.doAction(
                                    CartEvents.AddProduct(product.id?:"")
                                )

                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.ic_add),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(15.dp)
                        )
                    }
                }



            }

        }


    }

}