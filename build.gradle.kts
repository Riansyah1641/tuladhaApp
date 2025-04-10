// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath(libs.firebase.crashlytics.gradle)
        classpath(libs.gradle)
    }
}

plugins {
    id("com.android.application") version "8.0.2" apply false
    id("org.jetbrains.kotlin.android") version "2.0.21" apply false
    id("androidx.navigation.safeargs.kotlin") version "2.8.9" apply false
    id("com.google.devtools.ksp") version "2.0.21-1.0.27" apply false
    id("org.jlleitschuh.gradle.ktlint") version "11.6.1" apply false
    alias(libs.plugins.google.gms.google.services) apply false
}
