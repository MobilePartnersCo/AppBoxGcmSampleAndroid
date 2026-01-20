pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/MobilePartnersCo/AppBoxGcmSDK")
            // --------------------------------------------------------------
            // SDK 접근 설정
            // --------------------------------------------------------------
            credentials {
                username = providers.gradleProperty("gpr.user").getOrElse("")
                password = providers.gradleProperty("gpr.key").getOrElse("")
            }
            // --------------------------------------------------------------
        }
    }
}

rootProject.name = "appboxGcmSample"
include(":app")
 