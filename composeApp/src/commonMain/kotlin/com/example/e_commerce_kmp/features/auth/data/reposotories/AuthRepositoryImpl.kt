package com.example.e_commerce_kmp.features.auth.data.reposotories

import com.example.e_commerce_kmp.features.auth.data.datesource.auth_remote_data_source.AuthRemoteDateSource
import com.example.e_commerce_kmp.features.auth.data.datesource.auth_remote_data_source.AuthRemoteDateSourceImpl
import com.example.e_commerce_kmp.features.auth.domain.reposotories.AuthRepository
import com.example.e_commerce_kmp.features.network.response.AuthResponse

class AuthRepositoryImpl( var authRemoteDateSource: AuthRemoteDateSource)  : AuthRepository  {
    override suspend fun login(
        email: String,
        password: String
    ): Result<Unit> {
       val result =  authRemoteDateSource.login(email  , password)
        if (result.isSuccess){
            return Result.success(Unit)
        }else{
            return Result.failure(result.exceptionOrNull()?: Exception("Something Went Wrong "))
        }
    }

}