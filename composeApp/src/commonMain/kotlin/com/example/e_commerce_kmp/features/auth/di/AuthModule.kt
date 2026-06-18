package com.example.e_commerce_kmp.features.auth.di

import com.example.e_commerce_kmp.features.auth.data.datesource.auth_remote_data_source.AuthRemoteDateSource
import com.example.e_commerce_kmp.features.auth.data.datesource.auth_remote_data_source.AuthRemoteDateSourceImpl
import com.example.e_commerce_kmp.features.auth.data.reposotories.AuthRepositoryImpl
import com.example.e_commerce_kmp.features.auth.domain.reposotories.AuthRepository
import com.example.e_commerce_kmp.features.auth.domain.usecases.ForgetPassWordUseCase
import com.example.e_commerce_kmp.features.auth.domain.usecases.LogOutUseCase
import com.example.e_commerce_kmp.features.auth.domain.usecases.LoginUseCase
import com.example.e_commerce_kmp.features.auth.domain.usecases.ResetPassWordUseCase
import com.example.e_commerce_kmp.features.auth.domain.usecases.SignUpUseCase
import com.example.e_commerce_kmp.features.auth.domain.usecases.VerifyCodeUseCase
import com.example.e_commerce_kmp.features.auth.ui.screens.forgetpassword.ForgetPassWordViewModel
import com.example.e_commerce_kmp.features.auth.ui.screens.forgetpassword.NewPassWordViewModel
import com.example.e_commerce_kmp.features.auth.ui.screens.forgetpassword.VerifyCodeViewModel
import com.example.e_commerce_kmp.features.auth.ui.screens.login.LoginViewModel
import com.example.e_commerce_kmp.features.auth.ui.screens.register.RegisterViewModel
import com.example.e_commerce_kmp.features.commerce.ui.tabs.account.AccountViewModel
import com.example.e_commerce_kmp.features.commerce.usecases.GetLoggedUserData
import com.example.e_commerce_kmp.features.network.createHttpClient
import io.ktor.client.HttpClient
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val authModule = module{
    single<HttpClient> {
        createHttpClient(get ())
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
    factory {
        SignUpUseCase(get())
    }
    factory {
        ForgetPassWordUseCase(get())
    }
    factory {
        VerifyCodeUseCase(get())
    }
    factory {
        ResetPassWordUseCase(get())
    }
    factory {
        LogOutUseCase(get ())
    }
    factory {
        GetLoggedUserData(get ())
    }

    viewModel { LoginViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
    viewModel { ForgetPassWordViewModel(get()) }
    viewModel { VerifyCodeViewModel(get()) }
    viewModel { NewPassWordViewModel(get()) }
    viewModel { AccountViewModel(get () ,get())}
}
