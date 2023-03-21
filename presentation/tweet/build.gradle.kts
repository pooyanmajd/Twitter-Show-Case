plugins {
    id("twittershowcase.android.presentation")
    id("twittershowcase.android.library.compose")
}
android {
    namespace = "com.pooyan.dev.tweet"
}
dependencies {
    implementation(libs.kotlinx.datetime)
}
