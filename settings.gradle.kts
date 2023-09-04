pluginManagement {
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

rootProject.name = "QRCodeModular"
include(":app")
include(":app:core")
include(":app:features:home")
include(":app:features:promo")
include(":app:features:payment")
include(":app:features:transaction")
include(":app:features:portofolio")
include(":app:features:notification")
