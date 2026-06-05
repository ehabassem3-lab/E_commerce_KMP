package com.example.e_commerce_kmp.features.commerce.ui.tabs.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commerce_kmp.features.commerce.domain.entities.Category
import com.example.e_commerce_kmp.features.thenes.AppTypography
import com.example.e_commerce_kmp.features.thenes.Primary

@Composable
fun SubCategoryItem(
    category: Category
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Primary.copy(alpha = .1f))
            .border(width = 3.dp , color = Primary.copy(alpha = .5f) , shape = RoundedCornerShape(20.dp))
    ) {
        Text(
            text = category.name?.firstOrNull()?.uppercaseChar()?.toString() ?: "?",
            style = AppTypography.bodyMedium.copy(color = Primary , fontSize = 30.sp)
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(
            text = category.name?:"" ,
            style = AppTypography.bodyMedium.copy(color = Primary , fontSize = 10.sp)

        )

    }
}