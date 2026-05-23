package com.example.promobanner

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.ic_curisol
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource


data class PromoSlide(
    val imageUrl: String,
    val discountPercent: Int,
    val title: String,
    val subtitle: String,
    val ctaText: String,
    val backgroundColor: Color,
    val textColor: Color,
    val accentColor: Color,
)

val defaultSlides = listOf(
    PromoSlide(
        imageUrl = "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=800",
        discountPercent = 25,
        title = "For all Headphones\n& AirPods",
        subtitle = "UP TO",
        ctaText = "Shop Now",
        backgroundColor = Color(0xFFF5C518),
        textColor = Color(0xFF0D3B6E),
        accentColor = Color(0xFF0D3B6E),
    ),
    PromoSlide(
        imageUrl = "https://images.unsplash.com/photo-1585386959984-a4155224a1ad?w=800",
        discountPercent = 30,
        title = "Premium Speakers\n& Soundbars",
        subtitle = "SAVE",
        ctaText = "Explore",
        backgroundColor = Color(0xFF1A1A2E),
        textColor = Color(0xFFE0E0FF),
        accentColor = Color(0xFF7C83FD),
    ),
    PromoSlide(
        imageUrl = "https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=800",
        discountPercent = 20,
        title = "Smart Watches\n& Wearables",
        subtitle = "UP TO",
        ctaText = "Discover",
        backgroundColor = Color(0xFFE8F5E9),
        textColor = Color(0xFF1B5E20),
        accentColor = Color(0xFF2E7D32),
    ),
)

// ── Main Carousel ────────────────────────────────────────────────────────────

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PromoCarousel(
    slides: List<PromoSlide> = defaultSlides,
    autoScrollDelayMs: Long = 3500,
    modifier: Modifier = Modifier,
) {
    val pagerState = rememberPagerState(pageCount = { slides.size })
    val scope = rememberCoroutineScope()

    LaunchedEffect(pagerState) {
        while (true) {
            delay(autoScrollDelayMs)
            val next = (pagerState.currentPage + 1) % slides.size
            scope.launch {
                pagerState.animateScrollToPage(
                    page = next,
                    animationSpec = tween(durationMillis = 600, easing = EaseInOutCubic)
                )
            }
        }
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(220.dp)
        ) {

            HorizontalPager(
                state = pagerState,
                contentPadding = PaddingValues(horizontal = 16.dp),
                pageSpacing = 12.dp,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                PromoCard(slide = slides[page])
            }

            PagerDotIndicator(
                pageCount = slides.size,
                currentPage = pagerState.currentPage,
                targetPage = pagerState.targetPage,
                currentPageOffsetFraction = pagerState.currentPageOffsetFraction,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 14.dp)
                    .padding(horizontal = 10.dp, vertical = 10.dp)
            )
        }
    }
}


@Composable
fun PromoCard(
    slide: PromoSlide,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(180.dp)
            .shadow(elevation = 6.dp, shape = RoundedCornerShape(16.dp), clip = false)
            .clip(RoundedCornerShape(16.dp))
            .background(slide.backgroundColor),
    ) {
        // Product image — right side
        Image(
            painter = painterResource(Res.drawable.ic_curisol),

            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .fillMaxHeight()
                .fillMaxWidth(0.55f),
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            slide.backgroundColor,
                            slide.backgroundColor.copy(alpha = 0.85f),
                            slide.backgroundColor.copy(alpha = 0.3f),
                            Color.Transparent,
                        ),
                        startX = 0f,
                        endX = Float.POSITIVE_INFINITY,
                    )
                )
        )

        Column(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 20.dp, end = 130.dp, top = 16.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            color = slide.textColor,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 0.5.sp,
                        )
                    ) { append("${slide.subtitle}\n") }

                    withStyle(
                        SpanStyle(
                            color = slide.textColor,
                            fontSize = 38.sp,
                            fontWeight = FontWeight.ExtraBold,
                            letterSpacing = (-1).sp,
                        )
                    ) { append("${slide.discountPercent}%") }

                    withStyle(
                        SpanStyle(
                            color = slide.textColor,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    ) { append(" OFF") }
                },
                lineHeight = 40.sp,
            )

            // Subtitle line
            Text(
                text = slide.title,
                color = slide.textColor.copy(alpha = 0.85f),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 16.sp,
            )

            Spacer(Modifier.height(4.dp))

            // CTA Button
            Button(
                onClick = { /* navigate */ },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = slide.accentColor,
                    contentColor = slide.backgroundColor,
                ),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
                modifier = Modifier.height(36.dp),
            ) {
                Text(
                    text = slide.ctaText,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}


@Composable
fun PagerDotIndicator(
    pageCount: Int,
    currentPage: Int,
    targetPage: Int,
    currentPageOffsetFraction: Float,
    modifier: Modifier = Modifier,
    activeColor: Color = Color(0xFF0D3B6E),
    inactiveColor: Color = Color(0xFFBBBBBB),
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        repeat(pageCount) { index ->
            val isActive = index == currentPage
            val animatedWidth by animateDpAsState(
                targetValue = if (isActive) 20.dp else 8.dp,
                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
                label = "dot_width_$index",
            )
            val animatedColor by animateColorAsState(
                targetValue = if (isActive) activeColor else inactiveColor,
                animationSpec = tween(300),
                label = "dot_color_$index",
            )
            Box(
                modifier = Modifier
                    .height(8.dp)
                    .width(animatedWidth)
                    .clip(CircleShape)
                    .background(animatedColor),
            )
        }
    }
}


