plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.Main
    }
}

dependencies {
    implementation(Dependencies.EachKtx.Core)
    implementation(Dependencies.EachKtx.Lifecycle)
    implementationProject(ProjectConstants.Domain)
    implementationProject(ProjectConstants.SharedDomain)
    Dependencies.Compose.forEach(::implementation)
}
