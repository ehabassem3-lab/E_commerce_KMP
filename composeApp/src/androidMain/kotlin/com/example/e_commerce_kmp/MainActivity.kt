package com.example.e_commerce_kmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.di.commonModule
import com.example.e_commerce_kmp.features.auth.di.authModule
import com.example.e_commerce_kmp.features.thenes.MyAppTheme
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        startKoin {
            androidContext(this@MainActivity)

            modules(authModule, commonModule)
        }
        setContent {
            MyAppTheme{
                App()
            }

        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}