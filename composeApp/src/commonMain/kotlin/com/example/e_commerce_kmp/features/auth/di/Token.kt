package com.example.e_commerce_kmp.features.auth.di

import androidx.datastore.preferences.core.stringPreferencesKey

object DataStoreKeys{
    val USER_TOKEN = stringPreferencesKey("user_toke")
    val USER_Name = stringPreferencesKey("user_name")
    val USER_Email= stringPreferencesKey("user_email")
    val USER_Phone = stringPreferencesKey("user_phone")
    val USER_Password = stringPreferencesKey("user_password")

}