package com.example.e_commerce_kmp.features.thenes

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
val Blue = Color(0xff004182)
val White = Color(0xffffff)


private val LightColors = lightColorScheme(
    background = White,
    onBackground = Blue,
)

private val DarkColors = darkColorScheme(
    onPrimary = Color.Black,
    onBackground = Color.White,

)


@Composable
fun MyAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        content = content
    )
}