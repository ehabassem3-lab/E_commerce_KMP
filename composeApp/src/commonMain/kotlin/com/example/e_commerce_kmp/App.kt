package com.example.e_commerce_kmp

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.e_commerce_kmp.features.auth.ui.screens.edituser.EditUserPassWordView
import com.example.e_commerce_kmp.features.auth.ui.screens.edituser.EditUserView
import com.example.e_commerce_kmp.features.auth.ui.screens.forgetpassword.ForgetPassWordView
import com.example.e_commerce_kmp.features.auth.ui.screens.forgetpassword.NewPassWordView
import com.example.e_commerce_kmp.features.auth.ui.screens.forgetpassword.VerifyCodeView
import com.example.e_commerce_kmp.features.auth.ui.screens.login.Login
import com.example.e_commerce_kmp.features.auth.ui.screens.register.RegisterView
import com.example.e_commerce_kmp.features.commerce.ui.Cart.CartScreen
import com.example.e_commerce_kmp.features.commerce.ui.MainScreen
import com.example.e_commerce_kmp.features.commerce.ui.search.SearchScreen
import com.example.e_commerce_kmp.features.commerce.ui.SplashView
import com.example.e_commerce_kmp.features.commerce.ui.tabs.categories.ProductScreen
import com.example.e_commerce_kmp.features.commerce.ui.tabs.categories.ProductsDetailsScreen
import com.example.e_commerce_kmp.features.routes.AppRoutes

@Composable
@Preview
fun App() {

       val navController = rememberNavController()
    NavHost(
        navController= navController ,
        startDestination = AppRoutes.Splash
    ){

        composable <AppRoutes.EditUserPassWord>{
            EditUserPassWordView(navController)
        }
        composable <AppRoutes.EditUser>{
            EditUserView(navController)
        }
        composable <AppRoutes.Cart>{
            CartScreen(navController)
        }
        composable<AppRoutes.Login> {
            Login(navController)
        }
        composable <AppRoutes.SearchRoute>{
            SearchScreen(navController)
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
        composable <AppRoutes.ProductsScreen>{ backStackEntry ->
          val data =   backStackEntry.toRoute<AppRoutes.ProductsScreen>()
            ProductScreen(navController ,data.categoryId , data.subCategoryId)
        }
        composable < AppRoutes.ProductsDetailsRoute>{   backStackEntry ->
             val data = backStackEntry.toRoute<AppRoutes.ProductsDetailsRoute>()
            ProductsDetailsScreen(
                id = data.id ?:"" ,
              ratingsQuantity =   data.ratingsQuantity ,
             ratingsAverage =   data.ratingsAverage ,
              priceAfterDiscount =   data.priceAfterDiscount ,
               price =   data.price ,
              title =   data.title ,
                description =  data.description ,
                imageCover =  data.imageCover ,
                images = data.images ,
                sold = data.sold ,
                quantity = data.quantity ,
                availableColors = data.availableColors,

        navController =  navController
            )
        }
        composable<AppRoutes.VerifyCode> {
            VerifyCodeView(navController)
        }
        composable<AppRoutes.NewPassWord> {
            NewPassWordView(navController)
        }


    }
}