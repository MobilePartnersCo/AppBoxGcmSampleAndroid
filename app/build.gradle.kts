plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "kr.co.mobpa.appboxGcm.sdkSample"
    compileSdk = 35

    defaultConfig {
        applicationId = "kr.co.mobpa.appboxGcm.sdkSample"
        minSdk = 26
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // 이미 Firebase를 사용중일때
    implementation("com.google.firebase:firebase-messaging:24.1.1")

    // --------------------------------------------------------------
    // implementation 선언
    // --------------------------------------------------------------
    implementation("com.github.MobilePartnersCo:AppBoxSDKPackage:gcm-v1.0.7")
    // --------------------------------------------------------------
}