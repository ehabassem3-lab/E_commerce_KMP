package com.example.e_commerce_kmp.features.commerce.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.navigation.NavController
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.auth.di.DataStoreKeys
import com.example.e_commerce_kmp.features.routes.AppRoutes
import com.example.e_commerce_kmp.ic_splash_screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject

@Composable
fun SplashView(navController: NavController){
  var dataStore = koinInject<DataStore<Preferences>>()

    val userToken : Flow<String?> = dataStore.data.map {
        preferences ->
        preferences[DataStoreKeys.USER_TOKEN]
    }
    var token = ""


    LaunchedEffect(Unit){
        delay(2000)
        userToken.collectLatest {
            token = it?:""
            println(token)
            if (token.isNotEmpty()){
                navController.navigate(AppRoutes.MainScreen)
            }
            else{
                navController.navigate(AppRoutes.Login)
            }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(Res.drawable.ic_splash_screen),
            contentDescription = "" ,
            modifier = Modifier.fillMaxSize()
        )

    }



}