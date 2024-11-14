plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-android")
    kotlin("kapt")
}
android {
    namespace = "com.demo.example"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.demo.example"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled  = true
//       ndk {
//            abiFilters 'arm64-v8a', 'armeabi-v7a','x86','x86_64'
//        }
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
    bundle {
        language {
            enableSplit = false
        }
    }
//        packagingOptions {
//        exclude 'META-INF/DEPENDENCIES'
//        exclude 'META-INF/LICENSE'
//        exclude 'META-INF/LICENSE.txt'
//        exclude 'META-INF/license.txt'
//        exclude 'META-INF/NOTICE'
//        exclude 'META-INF/NOTICE.txt'
//        exclude 'META-INF/notice.txt'
//        exclude 'META-INF/ASL2.0'
//        exclude("META-INF/*.kotlin_module")
//    }
//    defaultConfig {
//        vectorDrawables.useSupportLibrary = true
//    }
//   sourceSets {
//        main {
//            jniLibs.srcDirs = ["libs"]
//        }
//    }
    buildFeatures {
        buildConfig = true
        dataBinding = true
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
//    implementation(project(":collageview"))

//    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${libs.versions.kotlin.get()}")
    implementation(libs.material)
//    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation("com.github.bumptech.glide:glide:4.9.0")

    implementation("com.airbnb.android:lottie:5.2.0")

//    new
//    implementation(libs.retrofit)
//    implementation(libs.retrofit.gson)
//    implementation(libs.room.runtime)
//    implementation(libs.room.ktx)
//
//    kapt(libs.room.compiler)
//    implementation(libs.coroutines.core)
//    implementation(libs.coroutines.android)
//    implementation(libs.lifecycle.viewmodel.ktx)
//    implementation(libs.lifecycle.livedata.ktx)

}