package com.example.e_commerce_kmp.features.auth.di

import com.example.e_commerce_kmp.features.auth.data.datesource.auth_remote_data_source.AuthRemoteDateSource
import com.example.e_commerce_kmp.features.auth.data.datesource.auth_remote_data_source.AuthRemoteDateSourceImpl
import com.example.e_commerce_kmp.features.auth.data.reposotories.AuthRepositoryImpl
import com.example.e_commerce_kmp.features.auth.domain.reposotories.AuthRepository
import com.example.e_commerce_kmp.features.auth.domain.usecases.LoginUseCase
import com.example.e_commerce_kmp.features.auth.ui.screens.login.LoginViewModel
import com.example.e_commerce_kmp.features.network.httpClient
import io.ktor.client.HttpClient
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val authModule = module{
    single<HttpClient> {
        httpClient

    }
    single<AuthRemoteDateSource> {
        AuthRemoteDateSourceImpl(get())
    }
    single<AuthRepository> {
        AuthRepositoryImpl(get () , get () )

    }
factory {
    LoginUseCase(get () )
}
    viewModel { LoginViewModel(get()) }
}
