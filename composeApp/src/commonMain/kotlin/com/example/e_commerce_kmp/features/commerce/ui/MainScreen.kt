package com.example.e_commerce_kmp.features.commerce.ui

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import org.jetbrains.compose.resources.DrawableResource

data class tabItem(
    val icon : DrawableResource ,
)
@Composable
fun MainScreen(
    navController: NavController
){
    Scaffold(
        bottomBar = {
            NavigationBar (){

            }
        }
    ) {

    }

}