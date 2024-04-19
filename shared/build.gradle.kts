plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlinx-serialization")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp")
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
        androidMain.dependencies {
            implementation(libs.androidx.core.ktx)
            implementation(libs.androidx.lifecycle.runtime.ktx)
            implementation("io.insert-koin:koin-android:3.5.6")
            implementation("io.insert-koin:koin-core-coroutines:3.5.6")

        }
        commonMain.dependencies {
            implementation("io.insert-koin:koin-core:3.5.6")


            implementation("com.arkivanov.decompose:decompose:3.0.0-beta01")
            implementation("com.arkivanov.decompose:extensions-compose:3.0.0-beta01")
            implementation("com.arkivanov.essenty:lifecycle:2.0.0-beta01")

            implementation("de.jensklingenberg.ktorfit:ktorfit-lib:1.11.0")

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

dependencies {
    add("kspCommonMainMetadata", "de.jensklingenberg.ktorfit:ktorfit-ksp:1.11.0")
    add("kspAndroid", "de.jensklingenberg.ktorfit:ktorfit-ksp:1.11.0")
}