package com.example.e_commerce_kmp.features.commerce.di

import com.example.e_commerce_kmp.features.commerce.data.cart.CartRemoteDataSourceImpl
import com.example.e_commerce_kmp.features.commerce.data.cart.CartRemoteDateSource
import com.example.e_commerce_kmp.features.commerce.data.cart.repository.CartRepositoryImpl
import com.example.e_commerce_kmp.features.commerce.data.home_repository.remote_data_source.HomeRemoteDataSource
import com.example.e_commerce_kmp.features.commerce.data.home_repository.remote_data_source.HomeRemoteDataSourceImpl
import com.example.e_commerce_kmp.features.commerce.data.home_repository.repositories.HomeRepositoriesImpl
import com.example.e_commerce_kmp.features.commerce.domain.repositories.CartRepository
import com.example.e_commerce_kmp.features.commerce.domain.repositories.HomeRepository
import com.example.e_commerce_kmp.features.commerce.ui.Cart.CartViewModel
import com.example.e_commerce_kmp.features.commerce.ui.tabs.categories.ProductsScreenViewModel
import com.example.e_commerce_kmp.features.commerce.ui.tabs.home.HomeTabViewModel
import com.example.e_commerce_kmp.features.commerce.usecases.GetCategoriesUseCase
import com.example.e_commerce_kmp.features.commerce.usecases.GetProductsUseCase
import com.example.e_commerce_kmp.features.commerce.usecases.GetSubCategoryUseCase
import io.ktor.client.HttpClient
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import kotlin.math.sin

val commerceModule = module {

    single <HomeRemoteDataSource>{
        HomeRemoteDataSourceImpl(get())
    }
    single <HomeRepository>{
        HomeRepositoriesImpl(get())
    }
    factory {
        GetProductsUseCase(get())
    }

    factory {
        GetCategoriesUseCase(get())
    }
    factory {
        GetSubCategoryUseCase(get())
    }
    viewModel {
        HomeTabViewModel(get() , get() ,get())
    }
    factory <CartRepository>{
        CartRepositoryImpl(get())
    }
    factory <CartRemoteDateSource>{
        CartRemoteDataSourceImpl(get())
    }
    viewModelOf(::ProductsScreenViewModel)
    single { CartViewModel(get()) }

}