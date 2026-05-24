package com.example.e_commerce_kmp

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.e_commerce_kmp.features.auth.ui.screens.forgetpassword.ForgetPassWordView
import com.example.e_commerce_kmp.features.auth.ui.screens.login.Login
import com.example.e_commerce_kmp.features.auth.ui.screens.register.RegisterView
import com.example.e_commerce_kmp.features.commerce.ui.MainScreen
import com.example.e_commerce_kmp.features.commerce.ui.SplashView
import com.example.e_commerce_kmp.features.routes.AppRoutes

@Composable
@Preview
fun App() {

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
        composable <AppRoutes.ForgetPassWord>{
            ForgetPassWordView(navController)
        }


    }
}