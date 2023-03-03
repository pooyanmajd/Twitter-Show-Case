plugins {
    id("twittershowcase.android.presentation")
    id("twittershowcase.android.library.compose")
}
android {
    namespace = "com.pooyan.login"
}
dependencies {
    implementation(libs.kotlinx.datetime)
}