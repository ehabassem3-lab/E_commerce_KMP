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
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.auth.ui.screens.login.LoginEvents
import com.example.e_commerce_kmp.features.auth.ui.screens.login.LoginViewModel
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.routes.AppRoutes
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
    val viewModel = koinViewModel<RegisterViewModel>()
    val state = viewModel.state.collectAsState().value
    val snackbarHostState = remember { SnackbarHostState() }
    LaunchedEffect(state.apiState) {
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
            else -> Unit
        }
    }

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
                     text = state.name?:"",
                     onValueChange = {
                           viewModel.doAction(RegisterEvents.OnNameChanged((it)))

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
                     text =  state.phone?:"",
                     onValueChange = {
                         viewModel.doAction(RegisterEvents.OnPhoneChanged((it)))


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
                     text =  state.email?:"",
                     onValueChange = {
                         viewModel.doAction(RegisterEvents.OnEmailChange((it)))

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
                     text = state.password?:"",
                     onValueChange = {
                         viewModel.doAction(RegisterEvents.OnPasswordChange((it)))

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

                         viewModel.doAction(RegisterEvents.OnSignUpClick)

                     } ,
                     isLoading =  state.apiState is Resources.Loading

                 )




             }

         }

}