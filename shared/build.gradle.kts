plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlinx-serialization")
    id("kotlin-parcelize")


}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation("com.arkivanov.decompose:decompose:3.0.0-beta01")
            implementation("com.arkivanov.decompose:extensions-compose:3.0.0-beta01")
            implementation("com.arkivanov.essenty:lifecycle:2.0.0-beta01")
        }
        commonTest.dependencies {
//            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "ru.mezhendosina.shared"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
