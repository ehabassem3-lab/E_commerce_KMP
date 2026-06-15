package com.example.e_commerce_kmp.features.commerce.ui.Cart

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.commerce.domain.entities.Product
import com.example.e_commerce_kmp.features.thenes.AppTypography
import com.example.e_commerce_kmp.features.thenes.DarkPrimary
import com.example.e_commerce_kmp.features.thenes.Primary
import com.example.e_commerce_kmp.ic_add
import com.example.e_commerce_kmp.ic_delete
import com.example.e_commerce_kmp.ic_discount_line
import com.example.e_commerce_kmp.ic_full_heart
import com.example.e_commerce_kmp.ic_heart
import com.example.e_commerce_kmp.ic_logo_route_small
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import kotlin.collections.get

@Composable
fun CartProductItem(
    product: Product,
    onProductClick : () -> Unit,
    ){
        val cartViewModel = koinInject <CartViewModel>()
        val state = cartViewModel.state.collectAsState()
        var latestProduct = state.value.latestCart?.product[product.id]
        val isInCart = latestProduct != null
        var   WishCliked  by remember { mutableStateOf(false) }


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
            model = product.imageCover ,
            error =painterResource( Res.drawable.ic_logo_route_small ),
            contentDescription = ""

        )
        Column (modifier = Modifier.fillMaxSize()) {


            Row(
                modifier = Modifier.height(30.dp).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    product.title ?: "",
                    modifier = Modifier.width(150.dp),
                    style = AppTypography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = DarkPrimary,
                        fontSize = 22.sp
                    )
                )
                Icon(
                    painter = painterResource(Res.drawable.ic_delete),
                    contentDescription = "",
                    tint = DarkPrimary,
                    modifier = Modifier.size(24.dp).clickable {
                        cartViewModel.doAction(CartEvents.DeleteProduct(product.id ?: ""))
                    }
                )

            }
            Spacer(modifier = Modifier.size(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth().height(40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    latestProduct?.priceAfterDiscount.toString() ?: "",
                    style = AppTypography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = DarkPrimary,
                        fontSize = 22.sp
                    )
                )
                Spacer(modifier = Modifier.size(8.dp))
                AddingProductsItem(
                    onAddClick = {
                        cartViewModel.doAction(
                            CartEvents.UpdateCart(
                                product.id ?: "",
                                latestProduct?.cartQuantity?.plus(1) ?: 0
                            )
                        )


                    },
                    onRemoveClick = {
                        val currentQty = latestProduct?.cartQuantity ?: 0
                        if (currentQty == 1) {
                            cartViewModel.doAction(
                                CartEvents.DeleteProduct(product.id ?: "")
                            )
                        } else {
                            cartViewModel.doAction(
                                CartEvents.UpdateCart(product.id ?: "", currentQty.minus(1))
                            )
                        }

                    },
                    text = (latestProduct?.cartQuantity ?: 0).toString()
                )

            }

        }
    }
    Spacer(modifier = Modifier.size(8.dp))




}