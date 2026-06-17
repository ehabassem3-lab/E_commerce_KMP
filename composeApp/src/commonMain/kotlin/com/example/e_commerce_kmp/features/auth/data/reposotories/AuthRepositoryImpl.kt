package com.example.e_commerce_kmp.features.auth.data.reposotories

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.example.e_commerce_kmp.features.auth.data.datesource.auth_remote_data_source.AuthRemoteDateSource
import com.example.e_commerce_kmp.features.auth.di.DataStoreKeys
import com.example.e_commerce_kmp.features.auth.domain.reposotories.AuthRepository

class AuthRepositoryImpl( var authRemoteDateSource: AuthRemoteDateSource , val dataStore: DataStore<Preferences>)  : AuthRepository  {
    override suspend fun login(
        email: String,
        password: String
    ): Result<Unit> {
       val result =  authRemoteDateSource.login(email  , password)
        if (result.isSuccess){
           dataStore.edit { preferences ->
               preferences[DataStoreKeys.USER_TOKEN] = result.getOrNull()?.token?:""

           }
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
                preferences[DataStoreKeys.USER_Password] = password
                preferences[DataStoreKeys.USER_Phone] = phone

            }
            println("${ request.getOrNull()} Repooooooooo")
           return Result.success(Unit)
        }else{
            return Result.failure(request.exceptionOrNull() ?: Exception("Some THing Went Worng"))

        }
    }

}