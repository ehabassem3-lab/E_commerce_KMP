package com.example.e_commerce_kmp.features.commerce.ui.tabs.categories

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.commerce.domain.entities.Category
import com.example.e_commerce_kmp.features.commerce.ui.tabs.home.HomeTabEvents
import com.example.e_commerce_kmp.features.commerce.ui.tabs.home.HomeTabSearchBar
import com.example.e_commerce_kmp.features.commerce.ui.tabs.home.HomeTabViewModel
import com.example.e_commerce_kmp.features.routes.AppRoutes
import com.example.e_commerce_kmp.features.thenes.AppTypography
import com.example.e_commerce_kmp.features.thenes.Primary
import com.example.e_commerce_kmp.features.utilities.ErrorView
import com.example.e_commerce_kmp.features.utilities.ShimmerCategoryItem
import com.example.e_commerce_kmp.ic_logo_route_small
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import kotlin.collections.emptyList

@Composable
fun CategoriesScreen(
    navController: NavController ,
    category:Category?

){
    val viewModel = koinViewModel <HomeTabViewModel>()
    val state = viewModel.state.collectAsState()
    var isSubCategoryCLicked by remember { mutableStateOf(false) }
    var subCategoryId by remember { mutableStateOf<String?>(null) }
    var selectedCategory = remember {
        if (state.value.categoriesApi is Resources.Success) {
            val categories =
                (state.value.categoriesApi as Resources.Success<List<Category>>).data

            val index = if (category == null) 0 else categories?.indexOf(category)

            mutableStateOf<Category?>(
                categories?.get(index ?: 0)
            )
        } else {
            mutableStateOf<Category?>(null)
        }
    }
    LaunchedEffect(Unit){
        viewModel.doAction(HomeTabEvents.LoadData)
        viewModel.doAction(      HomeTabEvents.GetSubCategories(selectedCategory?.value!!))
        isSubCategoryCLicked = false

    }
    Column (
        modifier = Modifier.fillMaxSize().background(Color.White)
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(start = 10.dp , end = 10.dp , top = 60.dp , bottom = 100.dp)
        ){

                Box(
                    modifier = Modifier.size(60.dp)
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(Res.drawable.ic_logo_route_small),
                        contentDescription = ""

                    )
                }
            HomeTabSearchBar(navController)
            Spacer(modifier = Modifier.size(15.dp))
            if (!isSubCategoryCLicked) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    if (state.value.categoriesApi is Resources.Success) {
                        val category =
                            (state.value.categoriesApi as Resources.Success<List<Category>>).data
                                ?: emptyList()

                        LazyColumn(
                            modifier = Modifier
                                .padding(5.dp)
                                .fillMaxHeight()
                                .width(150.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .background(Primary.copy(alpha = .1f))
                                .border(
                                    width = 3.dp,
                                    shape = RoundedCornerShape(20.dp),
                                    color = Primary.copy(alpha = .5f)
                                ),

                            ) {
                            items(category) {
                                Spacer(modifier = Modifier.size(10.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .fillMaxWidth()
                                        .height(50.dp)
                                        .background(if (selectedCategory == category) Color.White else Color.Transparent)
                                ) {
                                    if (selectedCategory?.value == it) {
                                        Box(
                                            modifier = Modifier.height(70.dp)
                                                .width(7.dp)
                                                .clip(RoundedCornerShape(20.dp))
                                                .background(Primary)
                                                .padding(end = 5.dp)

                                        )
                                    }

                                    Text(
                                        text = it.name ?: "",
                                        style = AppTypography.bodyMedium.copy(color = Primary),
                                        modifier = Modifier
                                            .padding(start = 5.dp)
                                            .clickable {
                                                selectedCategory?.value = it
                                                println(selectedCategory?.value)
                                            }
                                    )
                                }
                                Spacer(modifier = Modifier.size(10.dp))

                            }
                        }
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        )
                        {
                            Text(
                                text = "Sub Categories ",
                                style = AppTypography.bodyMedium.copy(
                                    color = Primary,
                                    fontSize = 30.sp
                                )
                            )
                            Spacer(modifier = Modifier.size(20.dp))
                            when (val subState = state.value.subCategoriesApi) {
                                is Resources.Error -> ErrorView { }
                                Resources.Loading -> ShimmerCategoryItem(isHorizonal =  false)
                                is Resources.Success<List<Category>> -> {
                                    LazyVerticalGrid(
                                        userScrollEnabled = true,
                                        columns = GridCells.Fixed(2),
                                        modifier = Modifier.fillMaxSize(),
                                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                                        verticalArrangement = Arrangement.spacedBy(12.dp),
                                        contentPadding = PaddingValues(vertical = 8.dp)
                                    ) {
                                        val subCategories = subState.data ?: emptyList()
                                        items(subCategories) { subCategory ->
                                            SubCategoryItem(subCategory) {
                                                subCategoryId = subCategory.id?:""
                                                isSubCategoryCLicked = true
                                            }

                                        }


                                    }

                                }

                                Resources.idle -> {
                                }
                            }


                        }

                    } else {
                        ShimmerCategoryItem(isHorizonal =  false)
                    }
                }
            }
            else{
               ProductScreen(navController , categoryId =  selectedCategory?.value?.id ?:"" ,  subCategoryId = subCategoryId?:"")

            }

        }

    }
}



