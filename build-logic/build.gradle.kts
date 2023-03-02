plugins {
    `kotlin-dsl`
}

group = "com.pooyan.twittershowcase.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("com.pooyan.twittershowcase.android.library") {
            id = "twittershowcase.android.library"
            implementationClass = "com.pooyan.logic.AndroidApplicationConventionPlugin"
        }
        register("com.pooyan.twittershowcase.android.compose") {
            id = "twittershowcase.android.compose"
            implementationClass = "com.pooyan.logic.AndroidApplicationComposeConventionPlugin"
        }
        register("com.pooyan.twittershowcase.android.hilt") {
            id = "twittershowcase.android.hilt"
            implementationClass = "com.pooyan.logic.AndroidHiltConventionPlugin"
        }
    }
}