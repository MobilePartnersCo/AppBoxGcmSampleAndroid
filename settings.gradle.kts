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

val localProperties = java.util.Properties()
val localPropertiesFile = File(rootDir, "local.properties")

if (localPropertiesFile.exists()) {
    localPropertiesFile.inputStream().use { localProperties.load(it) }
}

val gprUser: String = localProperties.getProperty("gpr.user") ?: ""
val gprKey: String = localProperties.getProperty("gpr.key") ?: ""

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
                username = gprUser
                password = gprKey
            }
        }
    }
}

rootProject.name = "appboxGcmSample"
include(":app")
 