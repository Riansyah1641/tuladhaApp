plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.devtools.ksp")
    id("com.google.firebase.crashlytics")
    id("org.jlleitschuh.gradle.ktlint")
    alias(libs.plugins.google.gms.google.services)
    id ("kotlin-kapt")
}

android {
    namespace = "com.thesis.tuladhaapp"
    compileSdk = 35



    defaultConfig {
        applicationId = "com.thesis.tuladhaapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.media3.ui)
    implementation(libs.androidx.preference)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity)

    // Navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    // Coil imageloader
    implementation(libs.coil)

    // splash screen
    implementation(libs.splashscreen)

    // RecyclerView
    implementation(libs.androidx.recyclerview)
    // circle crop image
    implementation(libs.circleimageview)
    // fragment ktx
    implementation(libs.androidx.fragment.ktx)
    // coroutine
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    // ktx lifecycle
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    // data store
    implementation(libs.androidx.datastore.preferences)
    // room database libraries
    implementation(libs.androidx.room.ktx)
    implementation(libs.firebase.auth)
    implementation(libs.androidx.credentials)
    implementation(libs.androidx.credentials.play.services.auth)
    implementation(libs.googleid)
    ksp(libs.androidx.room.compiler)
    // Lottie animation
    implementation(libs.lottie)
    // firebase
    implementation(platform("com.google.firebase:firebase-bom:32.3.1"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-crashlytics-ktx")
    // retrofit & okhttp
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.okhttp)
    // chucker
    debugImplementation(libs.library)
    releaseImplementation(libs.library.no.op)
    // Koin for Android
    implementation(libs.koin.android)
    // unit testing
    testImplementation(libs.mockk.android)
    testImplementation(libs.mockk.agent)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.turbine)
    testImplementation(libs.androidx.core.testing)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    testImplementation(libs.junit)

    // viewpager2
    implementation(libs.androidx.viewpager2)
    // super bottom sheet
    implementation(libs.superbottomsheet)
    // Smooth Bottom Bar
    implementation(libs.smoothbottombar)
    // Groupie
    implementation(libs.groupie)
    implementation(libs.groupie.viewbinding)
    // Media3 Exoplayer
    implementation(libs.androidx.media3.exoplayer)
    implementation(libs.androidx.media3.exoplayer.dash)
    implementation (libs.androidx.media3.exoplayer.v100)
    implementation(libs.androidx.media3.ui)
    // Skeleton layout
    implementation(libs.skeletonlayout)

    //progress bar
    implementation (libs.circularprogressbar)

    // OTP View
    implementation(libs.pinview)
    // Swipe Refresh Layout
    implementation(libs.androidx.swiperefreshlayout)
    // FancyToast
    implementation(libs.fancytoast)
    // Chips
    implementation(libs.material)
}