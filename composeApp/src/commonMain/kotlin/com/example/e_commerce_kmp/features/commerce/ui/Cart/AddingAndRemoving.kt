package com.example.e_commerce_kmp.features.commerce.ui.Cart
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.thenes.AppTypography
import com.example.e_commerce_kmp.features.thenes.Primary
import com.example.e_commerce_kmp.ic_add2
import com.example.e_commerce_kmp.ic_minus
import org.jetbrains.compose.resources.painterResource

@Composable
fun AddingProductsItem(
    onAddClick : () -> Unit ,
    onRemoveClick : () -> Unit ,
    text : String
){
    Row (
        modifier = Modifier
            .height(55.dp)
            .width(80.dp)
            .background(Primary,  shape = RoundedCornerShape(30.dp)),

        verticalAlignment = Alignment.CenterVertically ,
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        Icon(
            painter = painterResource(Res.drawable.ic_minus),
            contentDescription = "" ,
            modifier = Modifier.size(15.dp).clickable{
                onRemoveClick()
            } ,
            tint = Color.White
        )
        Text(
            text ,
            style = AppTypography.bodyMedium.copy(fontWeight = FontWeight.Bold , color = Color.White)
        )
        Icon(
            painter = painterResource(Res.drawable.ic_add2),
            contentDescription = "" ,
            modifier = Modifier.size(15.dp).clickable{
                onAddClick()
            } ,
            tint = Color.White
        )
    }
}