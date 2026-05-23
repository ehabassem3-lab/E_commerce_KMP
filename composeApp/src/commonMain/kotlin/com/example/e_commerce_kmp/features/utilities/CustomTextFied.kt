package com.example.e_commerce_kmp.features.utilities

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.thenes.AppTypography
import com.example.e_commerce_kmp.features.thenes.Primary
import com.example.e_commerce_kmp.ic_closed_eye
import com.example.e_commerce_kmp.ic_open_eye
import com.example.e_commerce_kmp.ic_search
import org.jetbrains.compose.resources.painterResource
import kotlin.jvm.Transient

@Composable
fun CustomTextField(
    hintText: String,
    text: String,
    onValueChange: (String) -> Unit ,
    hidePassword : Painter? ,
    width : Dp ,
    isSearchBar : Boolean ,
    onSearchClick: (() -> Unit)? = null,
    isPassword : Boolean = false
) {

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    Row  (
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .height(60.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color.White)
            .width(width),

        verticalAlignment = Alignment.CenterVertically  ,
        horizontalArrangement = Arrangement.SpaceBetween




    ) {
        if (isSearchBar){
            Icon(
                painter =  painterResource(Res.drawable.ic_search) ,
                contentDescription = "" ,
                modifier = Modifier.size(30.dp).padding(start =10.dp).clickable{
                    onSearchClick?.invoke()
                } ,
                tint = Primary
            )
        }

        TextField(
            modifier = Modifier.weight(1f),
            value = text,
            onValueChange = onValueChange,
            placeholder = {
                Text(text =
                    hintText ,
                    style = if (!isSearchBar)AppTypography.labelLarge else AppTypography.labelLarge.copy( color = Color(0xFF06004F))

                )
            },
            shape = RoundedCornerShape(15.dp),

            visualTransformation =
                if (isPassword && !passwordVisible)
                    PasswordVisualTransformation()
                else
                    VisualTransformation.None,

            colors = TextFieldDefaults.colors(
                disabledContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            textStyle = AppTypography.titleMedium.copy(color = Color.Black) ,

        )


      if (isPassword){
          Icon(
              painter = if (passwordVisible) painterResource(Res.drawable.ic_open_eye) else hidePassword!! ,
              contentDescription = "" ,
              modifier = Modifier.size(30.dp).padding(end = 10.dp).clickable{
                 passwordVisible = !passwordVisible
              } ,
              tint = Color.Gray
          )
      }
    }
}