package com.example.e_commerce_kmp.features.commerce.ui.tabs.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.auth.ui.screens.register.RegisterEvents
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.network.response.auth.UserDataResponse
import com.example.e_commerce_kmp.features.routes.AppRoutes
import com.example.e_commerce_kmp.features.thenes.AppTypography
import com.example.e_commerce_kmp.features.thenes.Primary
import com.example.e_commerce_kmp.features.utilities.CustomTextField
import com.example.e_commerce_kmp.features.utilities.ErrorView
import com.example.e_commerce_kmp.ic_closed_eye
import com.example.e_commerce_kmp.ic_log_out
import com.example.e_commerce_kmp.ic_logo_route_small
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject

@Composable
fun AccountScreen(navController: NavController,
){
    val viewModel = koinInject<AccountViewModel>()
    val state = viewModel.state.collectAsState().value
    val snackbarHostState = remember { SnackbarHostState() }
    val userData =
        (state.AccountDataStates as? Resources.Success<UserDataResponse>)?.data
    println(userData)
    println(userData)
    LaunchedEffect(Unit){
        viewModel.doAction(AccountEvents.getUserData)
    }
    LaunchedEffect(state.LogOutState){
        when(state.LogOutState){
            is Resources.Error -> {
                snackbarHostState.showSnackbar(message = "SomeThing Went Wrong While LogOut ")
            }
            is Resources.Success<*> -> {
                navController.navigate(AppRoutes.Login)
            }
            else -> {

            }
        }

    }
    Column (
        modifier =
            Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(start = 5.dp , end = 5.dp , top = 60.dp, bottom = 100.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().height(60.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Box(
                modifier = Modifier.size(60.dp)
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(Res.drawable.ic_logo_route_small),
                    contentDescription = ""

                )
            }
            Spacer(modifier = Modifier.size(100.dp))
            Icon(
                painter = painterResource(Res.drawable.ic_log_out),
                contentDescription = "",
                tint = Color.Red,
                modifier = Modifier.size(32.dp).clickable {
                    viewModel.doAction(AccountEvents.onLogOutClick)
                }
            )

        }
    }

}