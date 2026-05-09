package com.example.e_commerce_kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform