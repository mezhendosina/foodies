// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.kotlin.parcelize).apply(false)
    kotlin("plugin.serialization") version "1.9.22"
    id("com.google.devtools.ksp") version "1.9.22-1.0.16"
    id("de.jensklingenberg.ktorfit") version "1.11.0" apply false
}
