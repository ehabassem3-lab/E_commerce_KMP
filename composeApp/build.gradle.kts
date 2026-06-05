import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinxSerialization)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation("io.coil-kt.coil3:coil-network-okhttp")
            implementation("io.coil-kt.coil3:coil-compose:3.4.0")
            implementation("io.coil-kt.coil3:coil-network-okhttp:3.4.0")
            val koin = "4.1.1"
            implementation("androidx.core:core-splashscreen:1.0.1")

            implementation("io.coil-kt:coil-compose:2.6.0")

            implementation("androidx.datastore:datastore-core-okio:1.1.0")

            implementation("androidx.datastore:datastore:1.2.1")
            implementation("androidx.datastore:datastore-preferences:1.2.1")
            implementation(compose.material3)
            implementation("org.jetbrains.androidx.navigation:navigation-compose:2.8.0-alpha10")
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.activity.compose)
            implementation("io.ktor:ktor-client-okhttp:3.0.0")
            // Option 1: Android convenience package (includes koin-compose + koin-compose-viewmodel)
            implementation("io.insert-koin:koin-androidx-compose:${koin}")
// Option 2: Use multiplatform packages directly
            implementation("io.insert-koin:koin-compose:${koin}")
            implementation("io.insert-koin:koin-compose-viewmodel:${koin}")
            implementation("androidx.datastore:datastore-core-okio:1.1.0")
// Optional: Navigation integration
            implementation("io.insert-koin:koin-androidx-compose-navigation:${koin}")
        }
        commonMain.dependencies {
        val    ktor = "3.4.1"
            val koin = "4.1.1"
            val nav_version = "2.9.8"
            implementation("io.coil-kt.coil3:coil-compose:3.4.0")
            implementation("io.coil-kt.coil3:coil")
            implementation("io.coil-kt.coil3:coil-compose")
            implementation(libs.compose.shimmer)
            implementation("androidx.core:core-splashscreen:1.0.1")

            implementation(compose.components.resources)
            implementation("org.jetbrains.androidx.navigation:navigation-compose:2.8.0-alpha10")
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
            implementation(libs.io.insert.koin.koin.compose)
            implementation(libs.io.insert.koin.koin.compose.viewmodel)
            implementation("org.jetbrains.androidx.navigation:navigation-compose:2.8.0-alpha10")
// Optional: Navigation integration
            implementation(libs.koin.compose.viewmodel.navigation)
            implementation("androidx.datastore:datastore-core-okio:1.1.0")
            // DataStore library
            implementation("androidx.datastore:datastore:1.2.1")
            // The Preferences DataStore library
            implementation("androidx.datastore:datastore-preferences:1.2.1")
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.logging)
            implementation(libs.kotlinx.datetime)
            implementation(libs.koin.core)
            implementation("io.ktor:ktor-client-logging:${ktor}")
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.example.e_commerce_kmp"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.example.e_commerce_kmp"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
// =============== COMPOSE RESOURCES ===============
compose.resources {
    // Optional but recommended
    publicResClass = true
    packageOfResClass = "com.example.e_commerce_kmp"   // or your preferred package
    generateResClass = always  // or "auto"
}

dependencies {
    debugImplementation(libs.compose.uiTooling)
}

