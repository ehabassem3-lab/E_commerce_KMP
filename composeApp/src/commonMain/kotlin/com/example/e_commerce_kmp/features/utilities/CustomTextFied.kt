package com.example.e_commerce_kmp.features.utilities

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.example.e_commerce_kmp.features.thenes.AppTypography
import kotlin.jvm.Transient

@Composable
fun CustomTextField(
    hintText: String,
    text: String,
    onValueChange: (String) -> Unit ,
    hidePassword : Painter? ,
    isPassword : Boolean = false
) {

    Row  (
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .height(60.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color.White)
            .fillMaxWidth(),

        verticalAlignment = Alignment.CenterVertically  ,
        horizontalArrangement = Arrangement.SpaceBetween




    ) {

        TextField(
            value = text,
            onValueChange = onValueChange,
            placeholder = {
                Text(text = hintText , style = AppTypography.labelLarge)
            },
            shape = RoundedCornerShape(15.dp),

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
              painter = hidePassword!! ,
              contentDescription = "" ,
              modifier = Modifier.size(30.dp).padding(end = 10.dp) ,
              tint = Color.Gray
          )
      }
    }
}