package com.example.e_commerce_kmp.features.utilities

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import kotlin.math.absoluteValue

@Composable
fun ImageCarousel(
    images: DrawableResource
) {
    val pagerState = rememberPagerState(pageCount = { 3 })

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 32.dp),
            pageSpacing = 16.dp,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        ) { page ->

            val pageOffset = (
                    pagerState.currentPage - page + pagerState.currentPageOffsetFraction
                    ).absoluteValue

            val scale = 1f - (pageOffset * 0.15f)

            Image(
                painter = painterResource(images),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp))
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                        alpha = 1f - (pageOffset * 0.3f)
                    }
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Indicators
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(3) { index ->
                val selected = pagerState.currentPage == index

                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(if (selected) 10.dp else 8.dp)
                        .clip(RoundedCornerShape(50))
                )
            }
        }
    }
}