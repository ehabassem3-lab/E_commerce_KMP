package com.example.e_commerce_kmp.features.commerce.ui

import androidx.compose.foundation.Image
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
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject

@Composable
fun SplashView(
    navController: NavController
) {

    val dataStore = koinInject<DataStore<Preferences>>()

    LaunchedEffect(Unit) {

        delay(2000)

        val token = dataStore.data
            .map { preferences ->
                preferences[DataStoreKeys.USER_TOKEN]
            }
            .firstOrNull()

        if (!token.isNullOrEmpty()) {

            navController.navigate(AppRoutes.MainScreen) {
                popUpTo(AppRoutes.Splash) {
                    inclusive = true
                }
            }

        } else {

            navController.navigate(AppRoutes.Login) {
                popUpTo(AppRoutes.Splash) {
                    inclusive = true
                }
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(Res.drawable.ic_splash_screen),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}
