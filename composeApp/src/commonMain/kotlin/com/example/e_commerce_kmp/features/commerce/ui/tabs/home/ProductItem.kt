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
import coil3.compose.AsyncImage
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.commerce.domain.entities.Product
import com.example.e_commerce_kmp.features.thenes.AppTypography
import com.example.e_commerce_kmp.features.thenes.Primary
import com.example.e_commerce_kmp.ic_add
import com.example.e_commerce_kmp.ic_discount_line
import com.example.e_commerce_kmp.ic_heart
import com.example.e_commerce_kmp.ic_logo_route_small
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProductItem(
    productImage : String ,
    productTitle : String ,
    priceBefore : Double  ,
    priceAfter : Double ,
    rating : Double ,
    onProductClick : () -> Unit  ,
    onAddClick : () -> Unit,
    onWishClick : () -> Unit ,
){

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

            Box(modifier = Modifier.fillMaxWidth().height(160.dp)){


                AsyncImage(
                    modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.FillBounds ,
                    model = productImage ,
                    contentDescription = "" ,
                    error = painterResource(Res.drawable.ic_logo_route_small )
                )
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.TopEnd)
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(top = 10.dp )
                ){
                    Icon(
                        painter = painterResource(Res.drawable.ic_heart) ,
                        contentDescription = "" ,
                        tint =  Primary,
                        modifier = Modifier
                            .size(20.dp)
                            .clickable{
                                onWishClick()
                            }

                    )
                }

            }
            Spacer(modifier = Modifier.size(8.dp))
        Column (
            modifier = Modifier.fillMaxSize().padding( 10.dp)
        ){

            Text(
                text =  productTitle ,
                style = AppTypography.bodyMedium.copy(color = Primary, fontSize = 16.sp) ,
                modifier = Modifier
                    .height(30.dp)
                    .fillMaxWidth()
                    .padding(5.dp).clickable{
                        onProductClick()
                    }
            )
            Spacer(modifier = Modifier.size(8.dp))
            Row (
                modifier = Modifier.height(22.dp).fillMaxWidth(.95f)
            ){
                Text(
                    text =  "EGP ${priceAfter}" ,
                    style = AppTypography.bodyMedium.copy(color = Primary, fontSize = 14.sp)  ,
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
                        text =  " ${priceBefore}  EGP" ,
                        style = AppTypography.bodyMedium.copy(color = Primary, fontSize = 14.sp)  ,
                        modifier = Modifier.fillMaxSize()

                    )
                }

            }
            Spacer(modifier = Modifier.size(15.dp))
            Row (
                modifier = Modifier.fillMaxWidth().height(60.dp)
            ){
                Text(text = "Review (${rating}) ⭐"   ,
                    style = AppTypography.bodyMedium.copy(color = Primary, fontSize = 12.sp)  ,)
                Spacer(modifier = Modifier.size(40.dp))
                Box(
                    modifier = Modifier.size(40.dp).clip(CircleShape).background(Primary),
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        painter = painterResource(Res.drawable.ic_add) ,
                        contentDescription = "" ,
                        tint =  Color.White,
                        modifier = Modifier
                            .size(20.dp)
                            .clickable{
                                onAddClick()
                            }

                    )
                }


            }

        }


    }

}