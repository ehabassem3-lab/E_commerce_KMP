package com.example.e_commerce_kmp.features.auth.data.datesource.auth_remote_data_source

import com.example.e_commerce_kmp.features.network.response.auth.AuthResponse

interface AuthRemoteDateSource {
    suspend fun login(email : String , password : String) : Result<AuthResponse>
    suspend fun signUp(email : String , password : String , name : String , phone: String , rePassword : String) : Result<AuthResponse>
    suspend fun  forgetPassWord(email : String) : Result<Unit>
    suspend fun verifyCode(code : String) : Result<Unit>
    suspend fun updateUserPassWord(currentPassword : String , password : String , rePassword : String): Result<Unit>
    suspend fun updateUserData(name: String , email: String ,phone: String) : Result<Unit>
    suspend fun resetPassWord(email: String , newPassWord: String) : Result<Unit>
}