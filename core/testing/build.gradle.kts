plugins {
    id("twittershowcase.android.library")
    id("twittershowcase.android.library.compose")
    id("twittershowcase.android.hilt")
}

android {
    namespace = "com.pooyan.dev.testing"
}

dependencies {
    implementation(project(":core:common"))

    implementation(libs.kotlinx.datetime)

    api(libs.junit4)
    api(libs.androidx.test.core)
    api(libs.kotlinx.coroutines.test)
    api(libs.turbine)

    api(libs.androidx.test.espresso.core)
    api(libs.androidx.test.runner)
    api(libs.androidx.test.rules)
    api(libs.androidx.compose.ui.test)
    api(libs.hilt.android.testing)

    debugApi(libs.androidx.compose.ui.testManifest)
}