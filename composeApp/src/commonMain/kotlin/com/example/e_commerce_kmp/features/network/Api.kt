package com.example.e_commerce_kmp.features.network

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.e_commerce_kmp.features.auth.di.DataStoreKeys
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlin.math.log

fun createHttpClient(dataStore: DataStore<Preferences>) : HttpClient{
   return HttpClient {
       install(ContentNegotiation) {
           json(Json {
               ignoreUnknownKeys = true
               useAlternativeNames = false
           })
       }
       install(Logging){
           level = LogLevel.ALL
           logger = object : Logger {
               override fun log(message: String) {
                   println("Ktor: $message")
               }
           }
       }
       defaultRequest {
           url("https://ecommerce.routemisr.com/api/")
           contentType(ContentType.Application.Json)
           val token = runBlocking {
               dataStore.data.map {
                   it[DataStoreKeys.USER_TOKEN]
               }.firstOrNull()


           }
           token?.let {
               header("token",it)
           }
       }
}
}
//val httpClient = HttpClient {
//    install(ContentNegotiation) {
//        json(Json {
//            ignoreUnknownKeys = true
//            useAlternativeNames = false
//        })
//    }
//     install(Logging){
//         level = LogLevel.ALL
//         logger = Logger.DEFAULT
//     }
//    defaultRequest {
//        url("https://ecommerce.routemisr.com/api/")
//       contentType(ContentType.Application.Json)
//    }
//}