plugins {
    id("twittershowcase.android.library")
    id("twittershowcase.android.hilt")
}

android {
    namespace = "com.pooyan.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}