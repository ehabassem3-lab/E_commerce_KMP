package com.example.e_commerce_kmp.features.auth.ui.screens.register

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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.auth.ui.screens.login.LoginEvents
import com.example.e_commerce_kmp.features.auth.ui.screens.login.LoginViewModel
import com.example.e_commerce_kmp.features.thenes.AppTypography
import com.example.e_commerce_kmp.features.thenes.Primary
import com.example.e_commerce_kmp.features.utilities.CustomButton
import com.example.e_commerce_kmp.features.utilities.CustomTextField
import com.example.e_commerce_kmp.ic_closed_eye
import com.example.e_commerce_kmp.ic_route_logo
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RegisterView(navController: NavController   , modifier: Modifier = Modifier){
         Column (
             modifier = Modifier.fillMaxSize().background(Primary).padding(top = 80.dp , start = 10.dp , end = 10.dp)
         ){
             Box(
                 Modifier.fillMaxWidth().fillMaxHeight(.1f).padding(horizontal = 40.dp)
             ){
                 Image(
                     painter = painterResource(Res.drawable.ic_route_logo) ,
                     contentDescription = "The App Logo Login Page "  ,
                     modifier = Modifier.fillMaxSize()

                 )}
             Column(
                 modifier = Modifier
                     .padding(top = 50.dp , start = 10.dp )
                     .fillMaxSize()
             ){

                 Text(
                     text =  "Full Name" ,
                     style = AppTypography.titleMedium ,


                     )
                 Spacer(modifier.size(10.dp))
                 CustomTextField(
                     hintText =  "enter your full name" ,
                     text ="",
                     onValueChange = {


                     } ,
                     hidePassword = null ,
                     width = 400.dp,
                     isSearchBar = false,
                      isPassword = false
                 )
                 Spacer(modifier.size(30.dp))
                 Text("Mobile Number", style = AppTypography.titleMedium)
                 Spacer(modifier = Modifier.size(10.dp))

                 CustomTextField(
                     hintText = "enter your mobile no.",
                     text =  "",
                     onValueChange = {

                     },
                     isPassword = false,
                     width = 400.dp,
                     isSearchBar = false,
                     hidePassword = painterResource(Res.drawable.ic_closed_eye)
                 )
                 Spacer(modifier.size(30.dp))
                 Text("E-mail address", style = AppTypography.titleMedium)

                 Spacer(modifier = Modifier.size(10.dp))

                 CustomTextField(
                     hintText = "enter your email address",
                     text =  "",
                     onValueChange = {

                     },
                     width = 400.dp,
                     isSearchBar = false,
                     isPassword = false,

                     hidePassword = painterResource(Res.drawable.ic_closed_eye)
                 )
                 Spacer(modifier.size(30.dp))
                 Text("Password", style = AppTypography.titleMedium)

                 Spacer(modifier = Modifier.size(10.dp))

                 CustomTextField(
                     hintText = "enter your password",
                     text =  "",
                     onValueChange = {

                     },
                     width = 400.dp,
                     isSearchBar = false,
                     isPassword = true,
                     hidePassword = painterResource(Res.drawable.ic_closed_eye)
                 )

                 Spacer(Modifier.size(70.dp))
                 CustomButton(
                     text = "Sign Up" ,
                     onClick = {

                     } ,
                     isLoading =  false

                 )




             }

         }

}