package com.example.e_commerce_kmp.features.auth.domain.reposotories

import com.example.e_commerce_kmp.features.network.response.auth.UserDataResponse

interface AuthRepository {
    suspend fun login(email : String , password : String) : Result<Unit>
    suspend fun signUp(name : String ,email : String , password : String, rePassword: String, phone : String) : Result<Unit>
    suspend fun  logOut() : Result<Unit>
    suspend fun getUserData() : Result<UserDataResponse>
    suspend fun  forgetPassWord(email : String) : Result<Unit>
    suspend fun verifyCode(code : String) : Result<Unit>
    suspend fun resetPassWord(email: String , newPassWord: String) : Result<Unit>
    suspend fun updateUserData(name: String , email: String ,phone: String) : Result<Unit>
    suspend fun updateUserPassWord(currentPassword : String , password : String , rePassword : String): Result<Unit>
}