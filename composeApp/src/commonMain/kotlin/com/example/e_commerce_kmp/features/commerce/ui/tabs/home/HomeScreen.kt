package com.example.e_commerce_kmp.features.commerce.ui.tabs.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.thenes.Primary
import com.example.e_commerce_kmp.features.utilities.CustomButton
import com.example.e_commerce_kmp.features.utilities.CustomTextField
import com.example.e_commerce_kmp.features.utilities.ImageCarousel
import com.example.e_commerce_kmp.ic_cart
import com.example.e_commerce_kmp.ic_curisol
import com.example.e_commerce_kmp.ic_logo_route_small
import com.example.promobanner.PromoCarousel
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeScreen(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 10.dp , end = 10.dp , top = 60.dp)
    ){
        Box(
            modifier = Modifier.size(60.dp)
        ){ Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(Res.drawable.ic_logo_route_small) ,
                contentDescription = ""

            ) }
        Column (
            modifier =
                Modifier
                .fillMaxSize()
        ){
            Row (

                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp) ,
                verticalAlignment = Alignment.CenterVertically ,
                horizontalArrangement = Arrangement.Center

            ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth(.9f)
                        .height(70.dp)
                        .clip(RoundedCornerShape(25.dp))
                        .background(Color.White)
                        .border(
                            width = 3.dp,
                            color = Primary,
                            shape = RoundedCornerShape(25.dp)
                        )



                ) {
                    CustomTextField(
                        hintText = "what do you search for?",
                        text = "",
                        onValueChange = {

                        },
                        onSearchClick = {

                        },
                        width = 320.dp,
                        hidePassword =  null,
                        isSearchBar = true,
                        isPassword = false
                    ) }
                     Icon(
                    contentDescription = "",
                    painter = painterResource(Res.drawable.ic_cart) ,
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .size(30.dp) ,
                    tint = Primary
                )
            }
            PromoCarousel()




        }



    }

}