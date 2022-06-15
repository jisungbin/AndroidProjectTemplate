plugins {
    id("com.android.library")
    id("kotlin-android")
}

dependencies {
    api(Dependencies.EachKtx.Core)
    api(Dependencies.Jetpack.DataStore)
    api(project(ProjectConstants.Domain))
    api(project(ProjectConstants.SharedDomain))
    implementation(Dependencies.EachKtx.Activity)
    implementation(Dependencies.EachKtx.Fragment)
    Dependencies.SharedKtx.forEach(::api)
}
