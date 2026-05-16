package com.example.e_commerce_kmp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.e_commerce_kmp.features.auth.ui.screens.login.Login
import com.example.e_commerce_kmp.features.auth.ui.screens.register.RegisterView
import com.example.e_commerce_kmp.features.commerce.ui.MainScreen
import com.example.e_commerce_kmp.features.commerce.ui.SplashView
import com.example.e_commerce_kmp.features.network.httpClient
import com.example.e_commerce_kmp.features.network.request.LoginRequest
import com.example.e_commerce_kmp.features.network.response.AuthResponse
import com.example.e_commerce_kmp.features.routes.AppRoutes
import org.jetbrains.compose.resources.painterResource
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import kotlin.io.println

@Composable
@Preview
fun App() {
//     LaunchedEffect(Unit){
//
//         val response   =  httpClient.post("v1/auth/signin"){
//           setBody(LoginRequest("ehab123@gmail.com", "Ehab@123"))
//
//         }
//         println("Ehab Login Request ++${response.body<AuthResponse>()}")
//
//
//
//     }
       val navController = rememberNavController()
    NavHost(
        navController= navController ,
        startDestination = AppRoutes.Splash
    ){
        composable<AppRoutes.Login> {
            Login(navController)
        }
        composable<AppRoutes.Register> {
            RegisterView(navController)
        }
        composable<AppRoutes.MainScreen> {
            MainScreen(navController)
        }
        composable <AppRoutes.Splash>{
            SplashView(navController)
        }


    }
}