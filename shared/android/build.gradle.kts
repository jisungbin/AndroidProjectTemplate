plugins {
    id("com.android.library")
    id("kotlin-android")
    id("name.remal.check-dependency-updates") version Versions.BuildUtil.CheckDependencyUpdates
}

android {
    namespace = "land.sungbin.androidprojecttemplate.shared.android"
}

dependencies {
    val apis = listOf(
        Dependencies.Ktx,
        Dependencies.Jetpack.DataStore,
        Dependencies.Jetpack.ProfileInstaller,
        project(ProjectConstants.Domain),
        project(ProjectConstants.SharedDomain)
    ).dependenciesFlatten()
    apis.forEach(::api)
}
