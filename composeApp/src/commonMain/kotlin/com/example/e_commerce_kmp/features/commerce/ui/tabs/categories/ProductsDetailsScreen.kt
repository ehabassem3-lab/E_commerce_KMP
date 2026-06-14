package com.example.e_commerce_kmp.features.commerce.ui.tabs.categories

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.commerce.domain.entities.Product
import com.example.e_commerce_kmp.features.commerce.ui.tabs.home.HomeTabViewModel
import com.example.e_commerce_kmp.features.routes.AppRoutes
import com.example.e_commerce_kmp.features.thenes.AppTypography
import com.example.e_commerce_kmp.features.thenes.DarkPrimary
import com.example.e_commerce_kmp.features.thenes.Primary
import com.example.e_commerce_kmp.ic_add_cart
import com.example.e_commerce_kmp.ic_arrow_back
import com.example.e_commerce_kmp.ic_cart
import com.example.e_commerce_kmp.ic_full_heart
import com.example.e_commerce_kmp.ic_heart
import com.example.e_commerce_kmp.ic_logo_route_small
import com.example.e_commerce_kmp.ic_search
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProductsDetailsScreen(
   sold: Int? = null,
   images: List<String?>? = null,
   quantity: Int? = null,
   availableColors: List<String?>? = null,
   imageCover: String? = null,
   description: String? = null,
   title: String? = null,
   ratingsQuantity: Double? = null,
   ratingsAverage: Double? = null,
   price: Double? = null,
   id: String? = null,
   priceAfterDiscount: Double? = null ,
    navController: NavController
){
    val  number : MutableIntState = mutableIntStateOf(1)
         println(imageCover)
    LazyColumn (
        modifier = Modifier.fillMaxSize().padding(start = 10.dp , end = 10.dp , top = 75.dp )
    ){
        item{
            Row (
                modifier = Modifier.fillMaxWidth().height(30.dp)
            ){
                Icon(
                    painter = painterResource(Res.drawable.ic_arrow_back) ,
                    contentDescription = "" ,
                    tint = DarkPrimary,
                    modifier = Modifier.size(22.dp).clickable{
                        navController.navigate(AppRoutes.MainScreen)
                    }
                )
                Spacer(modifier = Modifier.size(100.dp))
                Text(
                    "Product Details" ,
                    style = AppTypography.bodyMedium.copy(color = DarkPrimary, fontSize = 22.sp , fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.size(30.dp))

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
                        navController.navigate(AppRoutes.Cart)
                    }
                )


            }
            Spacer(modifier = Modifier.size(10.dp))
            Column(
                modifier = Modifier.height(300.dp).fillMaxWidth().padding(horizontal = 10.dp)
                    .border( width = 2.dp , shape = RoundedCornerShape(20.dp ) , color = Primary.copy(alpha = .3f))
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize(), contentAlignment = Alignment.Center


                ) {


                    AsyncImage(
                        modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(20.dp)),
                        contentScale = ContentScale.FillBounds,
                        model = imageCover,
                        contentDescription = "",
                        error = painterResource(Res.drawable.ic_logo_route_small)
                    )
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.TopEnd)
                            .padding(top = 12.dp, end = 12.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .clickable {


                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter =
                                painterResource(Res.drawable.ic_heart),
                            contentDescription = "",
                            tint = Primary,
                            modifier = Modifier
                                .size(20.dp)


                        )
                    }

                }
            }
            Spacer(modifier = Modifier.size(15.dp))
            Row (
                modifier = Modifier.fillMaxWidth().height(30.dp) ,
                horizontalArrangement = Arrangement.SpaceEvenly ,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    title?:"" ,
                    style = AppTypography.bodyMedium.copy(color = DarkPrimary , fontSize = 22.sp)
                )
                Text(
                    price.toString(),
                    style = AppTypography.bodyMedium.copy(color = DarkPrimary , fontSize = 22.sp)
                )
            }
            Spacer(modifier = Modifier.size(15.dp))
            Row (
                modifier = Modifier.fillMaxWidth().height(40.dp) ,
                horizontalArrangement = Arrangement.SpaceAround ,
                verticalAlignment = Alignment.CenterVertically
            ){
                Column (
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(120.dp)
                        .border(width = 1.dp , color = DarkPrimary , shape = RoundedCornerShape(30.dp))
                    ,
                    verticalArrangement = Arrangement.Center ,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        " ${sold} sold" ,
                        style = AppTypography.bodyMedium.copy(color = DarkPrimary , fontSize = 18.sp , fontWeight = FontWeight.Bold)
                    )
                }
                Spacer(modifier = Modifier.size(15.dp))
                Text(
                    "⭐${ratingsAverage.toString()}  (${ratingsQuantity})",
                    style = AppTypography.bodyMedium.copy(color = DarkPrimary , fontSize = 16.sp)
                )
                Spacer(modifier = Modifier.size(40.dp))
                AddingProductsItem(
                    onAddClick = {  } ,
                    onRemoveClick = {} ,
                    QuantityNumber = number
                )

            }
            Spacer(modifier = Modifier.size(10.dp))
            Text("Description" , style = AppTypography
                .bodyMedium.copy(color = DarkPrimary , fontWeight = FontWeight.Bold , fontSize = 22.sp) )
            Spacer(modifier = Modifier.size(10.dp))
            Text(description?:"" , style = AppTypography
                .bodyMedium.copy( color = DarkPrimary.copy(alpha = .5f) , fontWeight = FontWeight.Bold , fontSize = 18.sp) )
            Spacer(modifier = Modifier.size(10.dp))
            Row (
                modifier = Modifier.fillMaxWidth().height(70.dp) ,
                verticalAlignment = Alignment.CenterVertically ,
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Column (
                    modifier = Modifier.fillMaxHeight().width(140.dp)
                ){
                    Text("Total Price " , style = AppTypography
                        .bodyMedium.copy(color = Primary , fontWeight = FontWeight.Bold , fontSize = 22.sp) )
                    Spacer(modifier = Modifier.size(10.dp))
                    Text("EGP${price} " , style = AppTypography
                        .bodyMedium.copy(color = DarkPrimary , fontWeight = FontWeight.Bold , fontSize = 22.sp) )
                }
                Spacer(modifier = Modifier.size(10.dp))
                Row (
                    modifier = Modifier
                        .height(60.dp)
                        .width(270.dp)
                        .background(Primary, shape = RoundedCornerShape(20.dp))
                        .clickable{

                    } ,
                    verticalAlignment = Alignment.CenterVertically ,
                    horizontalArrangement = Arrangement.SpaceEvenly ,

                ){
                    Icon(
                        painter = painterResource(Res.drawable.ic_add_cart) ,
                        contentDescription = "" ,
                        modifier = Modifier.size(24.dp) ,
                        tint = Color.White
                    )
                    Text(
                        "Add To Cart" , style = AppTypography
                        .bodyMedium.copy(color = Color.White  , fontWeight = FontWeight.Bold , fontSize = 22.sp) ,
                        modifier = Modifier.padding(end = 5.dp)
                    )

                }

            }



        }





    }

}
