package com.example.e_commerce_kmp.features.network.response.home

import kotlinx.serialization.Serializable

@Serializable
data class Metadata(
	val numberOfPages: Int? = null,
	val limit: Int? = null,
	val currentPage: Int? = null
)