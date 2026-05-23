package com.example.e_commerce_kmp.features.commerce.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.commerce.ui.tabs.account.AccountScreen
import com.example.e_commerce_kmp.features.commerce.ui.tabs.categories.CategoriesScreen
import com.example.e_commerce_kmp.features.commerce.ui.tabs.home.HomeScreen
import com.example.e_commerce_kmp.features.commerce.ui.tabs.wishlist.WishListScreen
import com.example.e_commerce_kmp.features.thenes.Primary
import com.example.e_commerce_kmp.ic_categories
import com.example.e_commerce_kmp.ic_heart
import com.example.e_commerce_kmp.ic_home
import com.example.e_commerce_kmp.ic_profile
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

data class tabItem(
    val icon : DrawableResource ,
)
@Composable
fun MainScreen(
    navController: NavController
){
    data class  navigationItem(val icon : DrawableResource , val index : Int)
    val navigationItems = listOf<navigationItem>(
        navigationItem(Res.drawable.ic_home , 0 ) ,
        navigationItem(Res.drawable.ic_categories , 1 ),
        navigationItem(Res.drawable.ic_heart , 2 ) ,
        navigationItem(Res.drawable.ic_profile , 3 )
    )
    val navBarItemColors = NavigationBarItemColors(
        selectedIconColor = Primary,
        selectedTextColor = Color.Transparent,
        selectedIndicatorColor = Color.Transparent,
        unselectedIconColor = Color.White,
        unselectedTextColor = Color.Transparent,
        disabledIconColor = Color.White,
        disabledTextColor = Color.White
    )
    var selectedIndex by remember { mutableIntStateOf(0) }
    Scaffold(
        bottomBar = {
            NavigationBar (
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(26.dp))
                    .background(Primary)
                     ,
                containerColor = Primary ,

            ){
                for (item in navigationItems){
                    val isSelected = selectedIndex == item.index
                    NavigationBarItem(
                        colors = navBarItemColors,
                        selected = isSelected ,
                        icon = {
                            Row(
                                modifier = Modifier
                                    .width(60.dp)
                                    .height(40.dp)
                                    .background(
                                        color = if (isSelected) Color.White  else Color.Transparent,
                                        shape = RoundedCornerShape(26.dp)
                                    )
                                   ,
                                verticalAlignment = Alignment.CenterVertically ,
                                horizontalArrangement = Arrangement.Center
                            ){
                                Icon(
                                    painter = painterResource(item.icon),
                                    modifier = Modifier
                                        .size(if (isSelected)26.dp else 22.dp ) ,
                                     contentDescription = ""
                                )
                            }


                               } ,
                        onClick = {
                       selectedIndex = item.index
                    })
                }

            }

        }
    ) {
        when(selectedIndex){
            0 -> HomeScreen(navController)
            1 -> CategoriesScreen(navController)
            2 -> WishListScreen(navController)
            3 -> AccountScreen(navController)

        }

    }

}