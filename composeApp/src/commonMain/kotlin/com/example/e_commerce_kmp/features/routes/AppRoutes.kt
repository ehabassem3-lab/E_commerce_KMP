package com.example.e_commerce_kmp.features.routes

import kotlinx.serialization.Serializable

sealed class AppRoutes {
    @Serializable
    object Login
    @Serializable
     object  Register
    @Serializable
    object  MainScreen
    @Serializable
    object Splash
    @Serializable
    object ForgetPassWord
}
