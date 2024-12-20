plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.supermariobrossartbook"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.supermariobrossartbook"
        minSdk = 21
        targetSdk = 34
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    // implementation ("androidx.recyclerview:recyclerview:1.2.1")
    // implementation ("com.google.android.material:material:1.9.0")
    // implementation ("androidx.drawerlayout:drawerlayout:1.1.1")
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}