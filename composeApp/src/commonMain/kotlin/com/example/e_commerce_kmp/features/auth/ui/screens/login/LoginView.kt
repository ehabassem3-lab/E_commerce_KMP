package com.example.e_commerce_kmp.features.auth.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.thenes.AppTypography
import com.example.e_commerce_kmp.features.thenes.Primary
import com.example.e_commerce_kmp.features.utilities.CustomButton
import com.example.e_commerce_kmp.features.utilities.CustomTextField
import com.example.e_commerce_kmp.ic_closed_eye
import com.example.e_commerce_kmp.ic_route_logo


import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun Login(
    navController: NavController ,
    modifier: Modifier = Modifier

){
    var viewmodel = koinViewModel<LoginViewModel>()
    Column  (
        Modifier
            .fillMaxSize()
            .background(Primary)
            .padding(top = 100.dp , start =  10.dp  , end = 10.dp)
            .clickable{
    }){
        Box(
            Modifier.fillMaxWidth().fillMaxHeight(.1f).padding(horizontal = 40.dp)
        ){
            Image(
                painter = painterResource(Res.drawable.ic_route_logo) ,
                contentDescription = "The App Logo Login Page "  ,
                modifier.fillMaxSize()

            )}
        Column(
            modifier = Modifier
                .padding(top = 50.dp , start = 10.dp )
                .fillMaxSize()
        ){
            Text(
                 text =  "Welcome Back To Route" ,
                style = AppTypography.titleLarge ,

            )
            Text(
                text =  "Please sign in with your mail" ,
                style = AppTypography.titleSmall ,

            )
            Spacer(modifier.size(40.dp))

            Text(
                text =  "User Name" ,
                style = AppTypography.titleMedium ,


            )
            Spacer(modifier.size(10.dp))

            CustomTextField(
                hintText =  "enter your name" ,
                text = "Email" ,
                onValueChange = {} ,
                 hidePassword = null
            )
            Spacer(modifier.size(30.dp))
            Text("Password", style = AppTypography.titleMedium)

            Spacer(modifier = Modifier.size(10.dp))

            CustomTextField(
                hintText = "enter your password",
                text = "Password",
                onValueChange = {},
                isPassword = true,
                hidePassword = painterResource(Res.drawable.ic_closed_eye)
            )
            Spacer(Modifier.size(15.dp))
            Text(
                "Forgot password" ,
                style = AppTypography.bodyMedium ,
                modifier = Modifier.padding(start = 230.dp).clickable{
                    TODO("Add The Forget Password Implemntaion")
                }

            )
            Spacer(Modifier.size(40.dp))
            CustomButton(
                text = "Login" ,
                onClick = {

                }
            )
            Spacer(Modifier.size(40.dp))
            Text(
                 "Don’t have an account? Create Account" ,
                textAlign = TextAlign.Center,
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally).clickable{

                    } ,
                     style = AppTypography.bodyMedium
                )



        }


    }

}