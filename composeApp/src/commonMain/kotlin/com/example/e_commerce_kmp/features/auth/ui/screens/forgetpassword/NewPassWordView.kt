package com.example.e_commerce_kmp.features.auth.ui.screens.forgetpassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.routes.AppRoutes
import com.example.e_commerce_kmp.features.thenes.AppTypography
import com.example.e_commerce_kmp.features.thenes.Primary
import com.example.e_commerce_kmp.features.utilities.CustomButton
import com.example.e_commerce_kmp.features.utilities.CustomTextField
import com.example.e_commerce_kmp.ic_arrow_back
import com.example.e_commerce_kmp.ic_route_logo
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun NewPassWordView(navController: NavController){
    val viewModel = koinViewModel<NewPassWordViewModel>()
    val state = viewModel.state.collectAsState().value
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(state.apiState){
        when (val apiState = state.apiState) {
            is Resources.Error -> {
                snackbarHostState.showSnackbar(
                    message = apiState.message ?: "Something Went Wrong"
                )
            }
            is Resources.Success -> {
                navController.navigate(AppRoutes.Login) {
                    popUpTo(AppRoutes.Register) { inclusive = true }

                }
                snackbarHostState.showSnackbar(
                    message = "Signed Up Successfully "
                )
            }

            else -> {}
        }
    }
    Scaffold (

        modifier = Modifier

            . fillMaxSize()
            .background(Primary)
            .padding(horizontal = 20.dp)
        ,
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(top = 12.dp, start = 20.dp)
            ) {
                Icon(
                    painter = painterResource(Res.drawable.ic_arrow_back),
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            navController.navigate(AppRoutes.Login)
                        }
                )
            }
        }
    ){ innerPadding->
        Column (
            modifier = Modifier.padding(top = 200.dp),
            verticalArrangement = Arrangement.Center ,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Image(
                painter = painterResource(Res.drawable.ic_route_logo)  ,
                contentDescription = "" ,
                modifier = Modifier.fillMaxWidth(.8f).fillMaxHeight(.2f)
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                "E-mail  address" ,
                modifier = Modifier.padding(end = 200.dp),
                style = AppTypography.titleMedium)
            Spacer(modifier = Modifier.size(20.dp))

            CustomTextField(
                hintText =  "enter your email " ,
                text = state.email?:"",
                onValueChange = {
                    viewModel.doAction(NewPassWordEvents.OnEmailChanged(it))
                } ,
                width = 420.dp,
                isSearchBar = false,
                hidePassword = null
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                "New PassWord" ,
                modifier = Modifier.padding(end = 200.dp),
                style = AppTypography.titleMedium)
            Spacer(modifier = Modifier.size(20.dp))

            CustomTextField(
                hintText =  "enter your new password" ,
                text = state.passWord?:"",
                onValueChange = {
                    viewModel.doAction(NewPassWordEvents.OnPassWordChanged(it))
                } ,
                width = 420.dp,
                isSearchBar = false,
                hidePassword = null
            )
            Spacer(modifier = Modifier.size(40.dp))

            CustomButton(
                text = "Reset Password" ,
                onClick = {
                    viewModel.doAction(NewPassWordEvents.OnChangeClick)
                } ,
                isLoading = state.apiState is Resources.Loading
            )




        }
    }

}