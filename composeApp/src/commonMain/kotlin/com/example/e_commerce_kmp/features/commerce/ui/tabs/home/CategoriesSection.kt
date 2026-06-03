package com.example.e_commerce_kmp.features.commerce.ui.tabs.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.commerce.domain.entities.Category
import com.example.e_commerce_kmp.features.thenes.AppTypography
import com.example.e_commerce_kmp.features.thenes.Primary
import com.example.e_commerce_kmp.features.utilities.ErrorView
import com.example.e_commerce_kmp.ic_logo_route_small
import org.jetbrains.compose.resources.painterResource

@Composable
fun CategoriesSection (
    categoryApiState : Resources<List<Category>>
){
    Column (
        modifier = Modifier
            .fillMaxWidth(.95f)
            .height(290.dp) ,
        verticalArrangement = Arrangement.Top ,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp) ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Categories",
                style = AppTypography.titleMedium.copy(
                    color = Primary,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                "View All" ,
                style = AppTypography.labelLarge.copy(
                    color = Primary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                ) ,
                modifier = Modifier.clickable {
                }
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        when(categoryApiState){
            is Resources.Error -> ErrorView {
                // Retry action
            }

            Resources.Loading -> CircularProgressIndicator(color = Primary)
            is Resources.Success<List<Category>> -> {
                val categories = categoryApiState.data ?: emptyList()
                LazyHorizontalGrid(
                    rows = GridCells.Fixed(2) ,
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ){
                    items(categories) { category ->
                        CategoryItem(category = category)
                    }
                }
            }
            else -> {}
        }
    }
}

@Composable
fun CategoryItem(
    category: Category,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(85.dp)
            .clickable {

            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            model = category.image,
            error = painterResource(Res.drawable.ic_logo_route_small),
            contentDescription = category.name,
            modifier = Modifier
                .size(75.dp)
                .clip(CircleShape)
                .background(Color(0xFFF4F6F9))
                .border(1.dp, Primary.copy(alpha = 0.1f), CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = category.name ?: "",
            style = AppTypography.titleSmall.copy(
                color = Primary,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
