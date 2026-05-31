package com.example.e_commerce_kmp.features.commerce.mappers

import com.example.e_commerce_kmp.features.commerce.domain.entities.Category
import com.example.e_commerce_kmp.features.network.response.home.categories_response.RemoteCategory

fun RemoteCategory.toCategory()  = Category(
    id = id?:"" ,
    image = image ?:"" ,
    name = name ?:"" ,
    category = category ?: ""
)



