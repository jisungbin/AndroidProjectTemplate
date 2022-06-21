plugins {
    id("com.android.library")
    id("kotlin-android")
    id("name.remal.check-dependency-updates") version Versions.BuildUtil.CheckDependencyUpdates
}

android {
    namespace = "land.sungbin.androidprojecttemplate.shared.compose"

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.Main
    }
}

dependencies {
    val projects = listOf(
        ProjectConstants.Domain,
        ProjectConstants.SharedDomain
    )
    projects.forEach(::projectImplementation)

    Dependencies.Compose.forEach(::implementation)
    Dependencies.Test.Local.forEach(::testImplementation)
    androidTestImplementation(Dependencies.Test.ComposeUI)
}
