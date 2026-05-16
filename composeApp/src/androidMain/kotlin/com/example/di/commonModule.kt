package com.example.di

import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.okio.OkioStorage
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.PreferencesSerializer
import androidx.datastore.preferences.core.stringPreferencesKey
import okio.FileSystem
import okio.Path.Companion.toPath
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import java.io.File

private const val DATA_STORE_FILE_NAME = "app_preferences.preferences_pb"
object DataStoreKeys{
    val USER_TOKEN = stringPreferencesKey("user_toke")
}
val commonModule = module {

    single<DataStore<Preferences>> {
        DataStoreFactory.create(
            storage = OkioStorage(
                fileSystem = FileSystem.SYSTEM,
                serializer = PreferencesSerializer,
                producePath = {
                    androidContext().filesDir
                        .resolve(DATA_STORE_FILE_NAME)
                        .absolutePath
                        .toPath()
                }
            )
        )
    }
}