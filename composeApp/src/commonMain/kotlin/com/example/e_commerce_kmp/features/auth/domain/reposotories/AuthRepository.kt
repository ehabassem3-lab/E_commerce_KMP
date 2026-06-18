package com.example.e_commerce_kmp.features.auth.domain.reposotories

interface AuthRepository {
    suspend fun login(email : String , password : String) : Result<Unit>
    suspend fun signUp(name : String ,email : String , password : String, rePassword: String, phone : String) : Result<Unit>
    suspend fun  logOut() : Result<Unit>
    suspend fun  forgetPassWord(email : String) : Result<Unit>
    suspend fun verifyCode(code : String) : Result<Unit>
    suspend fun resetPassWord(email: String , newPassWord: String) : Result<Unit>
}