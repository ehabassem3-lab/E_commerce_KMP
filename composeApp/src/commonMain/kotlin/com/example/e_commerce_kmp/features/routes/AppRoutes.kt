package com.example.e_commerce_kmp.features.routes

import kotlinx.serialization.Serializable

sealed class AppRoutes {
    @Serializable
  data  object Login: AppRoutes()
}
