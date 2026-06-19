package com.example.e_commerce_kmp.features.auth.data.reposotories

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.example.e_commerce_kmp.Res
import com.example.e_commerce_kmp.features.auth.data.datesource.auth_remote_data_source.AuthRemoteDateSource
import com.example.e_commerce_kmp.features.auth.di.DataStoreKeys
import com.example.e_commerce_kmp.features.auth.domain.reposotories.AuthRepository
import com.example.e_commerce_kmp.features.network.response.auth.UserDataResponse
import kotlinx.coroutines.flow.first

class AuthRepositoryImpl( var authRemoteDateSource: AuthRemoteDateSource , val dataStore: DataStore<Preferences>)  : AuthRepository  {
    override suspend fun login(
        email: String,
        password: String
    ): Result<Unit> {
       val result =  authRemoteDateSource.login(email  , password)
        if (result.isSuccess){
           dataStore.edit { preferences ->
               preferences[DataStoreKeys.USER_TOKEN] = result.getOrNull()?.token?:""
               preferences[DataStoreKeys.USER_Email] =  result.getOrNull()?.user?.email?:""
               preferences[DataStoreKeys.USER_Name] =  result.getOrNull()?.user?.name?:""
               preferences[DataStoreKeys.USER_Password] = password
           }
            println(dataStore.data.first())

            return Result.success(Unit)

        }else{
            return Result.failure(result.exceptionOrNull()?: Exception("Something Went Wrong "))
        }
    }

    override suspend fun signUp(
        name: String,
        email: String,
        password: String,
        rePassword: String ,
        phone: String
    ): Result<Unit> {
         val request = authRemoteDateSource.signUp(email ,password,name, rePassword = password,
             phone = phone
         )

        if (request.isSuccess){
            dataStore.edit { preferences ->
                preferences[DataStoreKeys.USER_Name] = name
                preferences[DataStoreKeys.USER_Email] = email

            }
            println("${ request.getOrNull()} Repooooooooo")
           return Result.success(Unit)
        }else{
            return Result.failure(request.exceptionOrNull() ?: Exception("Some THing Went Worng"))

        }
    }

    override suspend fun logOut()  : Result<Unit>{
      dataStore.edit {
          preferences -> preferences.clear()
      }
        return Result.success(Unit)
    }

    override suspend fun getUserData(): Result<UserDataResponse> {
        val preferences = dataStore.data.first()
        return try {
         Result.success(
            UserDataResponse(
                name = preferences[DataStoreKeys.USER_Name]?:"",
                email = preferences[DataStoreKeys.USER_Email]?:"",
                passWord =  preferences[DataStoreKeys.USER_Password] ?:""
            )
        )
        }catch (e : Throwable){
             Result.failure(e)
        }


    }


    override suspend fun forgetPassWord(email: String): Result<Unit> {
        val request = authRemoteDateSource.forgetPassWord(email)
     return   if (request.isSuccess){
            println("${ request.getOrNull()} Repooooooooo")
             Result.success(Unit)
        }else{
         Result.failure(Throwable(request.exceptionOrNull()))
        }
    }

    override suspend fun verifyCode(code: String): Result<Unit> {
          val request = authRemoteDateSource.verifyCode(code)
        return   if (request.isSuccess){
            println("${ request.getOrNull()} Repooooooooo")
            Result.success(Unit)
        }else{
            Result.failure(Throwable(request.exceptionOrNull()))
        }

     }

    override suspend fun resetPassWord(
        email: String,
        newPassWord: String
    ): Result<Unit> {
        val request = authRemoteDateSource.resetPassWord(email,newPassWord)
      return  if (request.isSuccess){
          println("${ request.getOrNull()} Repooooooooo")
          Result.success(Unit)
        }else{
          Result.failure(Throwable(request.exceptionOrNull()))
        }
    }

}