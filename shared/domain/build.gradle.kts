plugins {
    id("com.android.library")
    id("kotlin-android")
    id("name.remal.check-dependency-updates") version Versions.BuildUtil.CheckDependencyUpdates
}

dependencies {
    val apis = listOf(
        Dependencies.Coroutine,
        Dependencies.Util.Logeukes
    )
    apis.forEach(::api)
}
