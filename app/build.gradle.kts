plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp") version "1.9.24-1.0.20"  // For Room compiler
}

android {
    namespace = "com.example.chamasmart"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.chamasmart"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
        compose = true // Merged compose here
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
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation("androidx.recyclerview:recyclerview:1.4.0") // Or implementation(libs.androidx.recyclerview)
    implementation("androidx.activity:activity-ktx:1.9.2")  // For viewModels() delegate
    // implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4") // Already included via libs.androidx.lifecycle.runtime.ktx or transitively
    implementation("com.google.android.material:material:1.12.0")  // For Material components

    // Room Database
    implementation("androidx.room:room-runtime:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")  // For annotation processing
    implementation("androidx.room:room-ktx:2.6.1")  // Kotlin extensions

    // RecyclerView
    implementation(libs.androidx.recyclerview) // Using the version catalog alias

    // Material Design - This was outside, moved in
    implementation("com.google.android.material:material:1.12.0")

    // Lifecycle components (for ViewModel and LiveData) - These were outside, moved in
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.4")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
