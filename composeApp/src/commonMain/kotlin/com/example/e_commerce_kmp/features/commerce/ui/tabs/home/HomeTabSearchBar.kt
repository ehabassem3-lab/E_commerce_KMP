package com.example.e_commerce_kmp.features.commerce.ui.tabs.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.routes.AppRoutes
import com.example.e_commerce_kmp.features.thenes.Primary
import com.example.e_commerce_kmp.features.utilities.CustomTextField
import com.example.e_commerce_kmp.ic_cart
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeTabSearchBar(navController: NavController){
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
                .size(30.dp).clickable{
                      navController.navigate(AppRoutes.Cart)
                } ,
            tint = Primary
        )
    }
}