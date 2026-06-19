package com.example.e_commerce_kmp.features.auth.ui.screens.edituser

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
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
import com.example.e_commerce_kmp.features.commerce.ui.tabs.account.AccountEvents
import com.example.e_commerce_kmp.features.commerce.ui.tabs.account.AccountScreen
import com.example.e_commerce_kmp.features.commerce.ui.tabs.account.AccountViewModel
import com.example.e_commerce_kmp.features.routes.AppRoutes
import com.example.e_commerce_kmp.features.thenes.AppTypography
import com.example.e_commerce_kmp.features.thenes.Primary
import com.example.e_commerce_kmp.features.utilities.CustomButton
import com.example.e_commerce_kmp.features.utilities.CustomTextField
import com.example.e_commerce_kmp.ic_arrow_back
import com.example.e_commerce_kmp.ic_route_logo
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject

@Composable
fun EditUserView(navController: NavController){

    val viewModel = koinInject<AccountViewModel>()
    val state  =viewModel.state.collectAsState().value
    val snackbarHostState = remember { SnackbarHostState() }
    LaunchedEffect(state.UpdateUserDateApi){
        when(state.UpdateUserDateApi){
            is Resources.Error -> {
                launch {
                    snackbarHostState.showSnackbar(
                        message = "Error While  Updating The data "
                    )
                }
            }
            Resources.Loading -> {}
            is Resources.Success<*> -> {
                launch {
                    snackbarHostState.showSnackbar(
                        message = "Data Updated Successfully"
                    )
                }
                delay(1000)
                navController.navigate(AppRoutes.MainScreen)
            }
            Resources.idle -> {}
            else -> {

            }
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
                            navController.navigate(AppRoutes.MainScreen)
                        }
                )
            }
        },
        snackbarHost = {
            SnackbarHost(
                hostState =  snackbarHostState ,

                ){
                Snackbar(
                    snackbarData = it ,
                    containerColor = Color.White ,
                    contentColor = Primary ,
                    shape = RoundedCornerShape(16.dp)
                )
            }
        }
    ){ innerPadding->
        Column (
            modifier = Modifier.padding(top = 100.dp),
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
                "Name " ,
                modifier = Modifier.padding(end = 250.dp),
                style = AppTypography.titleMedium)
            Spacer(modifier = Modifier.size(20.dp))
            CustomTextField(
                hintText =  "enter your name " ,
                text = state.name?:"",
                onValueChange = {
                   viewModel.doAction(AccountEvents.OnNameChanged(it))

                } ,
                width = 420.dp,
                isSearchBar = false,
                hidePassword = null
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                "Email " ,
                modifier = Modifier.padding(end = 250.dp),
                style = AppTypography.titleMedium)
            Spacer(modifier = Modifier.size(20.dp))
            CustomTextField(
                hintText =  "enter the email  " ,
                text = state.email?:"",
                onValueChange = {
                    viewModel.doAction(AccountEvents.OnEmailChanged(it))

                } ,
                width = 420.dp,
                isSearchBar = false,
                hidePassword = null
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                "Phone  " ,
                modifier = Modifier.padding(end = 250.dp),
                style = AppTypography.titleMedium)
            Spacer(modifier = Modifier.size(20.dp))
            CustomTextField(
                hintText =  "enter the phone " ,
                text = state.phone?:"",
                onValueChange = {
                    viewModel.doAction(AccountEvents.OnPhoneChanged(it))

                } ,
                width = 420.dp,
                isSearchBar = false,
                hidePassword = null
            )
            Spacer(modifier = Modifier.size(40.dp))

            CustomButton(
                text = "Update Data" ,
                onClick = {
                     viewModel.doAction(AccountEvents.updateUserDate)
                } ,
                isLoading = state.UpdateUserDateApi is Resources.Loading
            )




        }
    }

}