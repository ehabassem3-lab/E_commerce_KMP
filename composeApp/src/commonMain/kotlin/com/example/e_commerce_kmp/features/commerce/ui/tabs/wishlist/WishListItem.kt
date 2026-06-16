package com.example.e_commerce_kmp.features.commerce.ui.tabs.wishlist

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.network.response.wish.RemoteWish
import com.example.e_commerce_kmp.features.thenes.AppTypography
import com.example.e_commerce_kmp.features.thenes.DarkPrimary
import com.example.e_commerce_kmp.ic_logo_route_small
import org.jetbrains.compose.resources.painterResource

@Composable
fun WishListItem(
    remmoteWish : RemoteWish? = null ,
    onWishClick : () -> Unit  ,
     onAddToCart : () -> Unit
) {

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .border( width = 1.dp  , shape =  RoundedCornerShape(20.dp),  color = DarkPrimary)
    ){
        AsyncImage(
            modifier = Modifier.fillMaxHeight().width(130.dp) .border( width = 1.dp  , shape =  RoundedCornerShape(20.dp),  color = DarkPrimary)
            ,
            contentScale = ContentScale.FillBounds ,
            model = remmoteWish?.imageCover ,
            error =painterResource( Res.drawable.ic_logo_route_small ),
            contentDescription = ""

        )
        Column (modifier = Modifier.fillMaxSize()) {


            Row(
                modifier = Modifier.height(30.dp).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    remmoteWish?.title ?: "",
                    modifier = Modifier.width(150.dp),
                    style = AppTypography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = DarkPrimary,
                        fontSize = 22.sp
                    )
                )


            }
            Spacer(modifier = Modifier.size(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth().height(40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    remmoteWish?.price.toString() ?: "",
                    style = AppTypography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = DarkPrimary,
                        fontSize = 22.sp
                    )
                )
                Spacer(modifier = Modifier.size(8.dp))

            }

        }
    }
    Spacer(modifier = Modifier.size(8.dp))
}