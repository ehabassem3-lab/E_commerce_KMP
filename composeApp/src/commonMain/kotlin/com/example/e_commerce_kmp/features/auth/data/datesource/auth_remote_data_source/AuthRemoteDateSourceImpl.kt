package com.example.e_commerce_kmp.features.auth.data.datesource.auth_remote_data_source

import com.example.e_commerce_kmp.features.network.createHttpClient
import com.example.e_commerce_kmp.features.network.request.auth.LoginRequest
import com.example.e_commerce_kmp.features.network.request.auth.SignUpRequest
import com.example.e_commerce_kmp.features.network.response.auth.AuthResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.isSuccess

class AuthRemoteDateSourceImpl( private val httpClient: HttpClient) : AuthRemoteDateSource {

    override suspend fun login(
        email: String,
        password: String
    ): Result<AuthResponse> {

        try{
            val response = httpClient.post("v1/auth/signin"){
                setBody(LoginRequest(email, password))
            }
            val authResponse = response.body<AuthResponse>()
            return if (response.status.isSuccess()){
                println(response.status.toString())
                println(email)
                println(password)
                Result.success(authResponse)
            } else{
                Result.failure(Exception(
                    "Failure During the Login  ${authResponse.message} "))
            }
        }
        catch (t : Throwable){
          return  Result.failure(t)
        }

    }

    override suspend fun signUp(
        email: String,
        password: String,
        name: String,
        phone: String,
        rePassword: String
    ): Result<AuthResponse> {
        try {


          val signUpRequest =
              httpClient.post("v1/auth/signup")
          { setBody(SignUpRequest(name,email,password , rePassword = password,phone)) }
        val response = signUpRequest.body<AuthResponse>()
     return   if (signUpRequest.status.isSuccess()){
         println("${response.user}  dataSoruce")
             Result.success(response)
        }else{
             Result.failure(Exception(response.message ))
        }
        }catch (e : Throwable){
         return    Result.failure(e)

        }

    }
}