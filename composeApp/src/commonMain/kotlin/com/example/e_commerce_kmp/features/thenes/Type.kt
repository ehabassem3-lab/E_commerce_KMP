package com.example.e_commerce_kmp.features.thenes
import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val AppTypography = Typography(

    titleLarge = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold ,
        color = Color.White

    ),

    titleMedium = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold ,
        color = Color.White
    ),

    titleSmall = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Light ,
        color = Color.White
    ),

    bodyMedium = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal ,
        color = Color.White
    ),

    labelLarge = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Light ,
        color = Color.Gray
    )
)