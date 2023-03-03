plugins {
    id("twittershowcase.android.library")
    id("kotlinx-serialization")
    id("twittershowcase.android.hilt")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}
android {
    buildFeatures {
        buildConfig = true
    }
    namespace = "com.pooyan.network"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.datetime)

    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}