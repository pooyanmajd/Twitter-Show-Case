pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Twitter Show Case"
include(":app")
include(":data")
include(":data:network")
include(":domain")
include(":presentation")
include(":presentation:login")
include(":core")
include(":core:common")
include(":core:design")
include(":core:ui")
include(":data:logic")
include(":core:testing")
include(":presentation:tweet")
include(":data:datastore")
include(":core:model")
