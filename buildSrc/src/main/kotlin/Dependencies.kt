object Dependencies {
    const val Ksp = "com.google.devtools.ksp:symbol-processing-api:${Versions.Ksp}"
    const val Coroutine =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Essential.Coroutines}"

    object Orbit {
        const val Test = "org.orbit-mvi:orbit-test:${Versions.Orbit}"
        const val Main = "org.orbit-mvi:orbit-viewmodel:${Versions.Orbit}"
    }

    val Ktx = listOf(
        "androidx.core:core-ktx:${Versions.Ktx.Core}",
        "androidx.fragment:fragment-ktx:${Versions.Ktx.Fragment}",
        "androidx.activity:activity-ktx:${Versions.Ktx.Activity}",
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Ktx.Lifecycle}",
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Ktx.Lifecycle}"
    )

    val Compose = listOf(
        "androidx.activity:activity-compose:${Versions.Ktx.Activity}",
        "androidx.compose.material:material:${Versions.Compose.Main}",
        "androidx.compose.ui:ui-tooling-preview:${Versions.Compose.Main}",
        "com.github.skydoves:landscapist-coil:${Versions.Compose.Landscapist}",
        "com.google.accompanist:accompanist-placeholder:${Versions.Compose.Accompanist}",
        "com.google.accompanist:accompanist-swiperefresh:${Versions.Compose.Accompanist}",
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Compose.LifecycleViewModel}",
        "com.google.accompanist:accompanist-navigation-animation:${Versions.Compose.Accompanist}",
        "androidx.constraintlayout:constraintlayout-compose:${Versions.Compose.ConstraintLayout}"
    )

    val Ui = listOf(
        "androidx.core:core-splashscreen:${Versions.Ui.Splash}",
        "com.google.android.material:material:${Versions.Ui.Material}",
        "com.google.android.gms:play-services-oss-licenses:${Versions.OssLicense.Main}"
    )

    val Jackson = listOf(
        "com.fasterxml.jackson.core:jackson-core:${Versions.Util.Jackson}",
        "com.fasterxml.jackson.core:jackson-databind:${Versions.Util.Jackson}",
        "com.fasterxml.jackson.core:jackson-annotations:${Versions.Util.Jackson}",
        "com.fasterxml.jackson.module:jackson-module-kotlin:${Versions.Util.Jackson}"
    )

    val Network = listOf(
        "com.squareup.retrofit2:retrofit:${Versions.Network.Retrofit}",
        "com.squareup.okhttp3:logging-interceptor:${Versions.Network.OkHttp}",
        "com.squareup.retrofit2:converter-jackson:${Versions.Network.Retrofit}"
    )

    object EachUtil { // Erratum 은 :presentation 에서만 쓰임
        const val Erratum = "land.sungbin:erratum:${Versions.Util.Erratum}"
        const val Logeukes = "land.sungbin:logeukes:${Versions.Util.Logeukes}"
    }

    val Analytics = listOf(
        "com.github.anrwatchdog:anrwatchdog:${Versions.Analytics.AnrWatchDog}"
    )

    object Jetpack {
        const val Room = "androidx.room:room-ktx:${Versions.Jetpack.Room}"
        const val Hilt = "com.google.dagger:hilt-android:${Versions.Jetpack.Hilt}"
        const val DataStore =
            "androidx.datastore:datastore-preferences:${Versions.Jetpack.DataStore}"
        const val ProfileInstaller =
            "androidx.profileinstaller:profileinstaller:${Versions.Jetpack.ProfileInstaller}"
    }

    object Compiler {
        const val RoomKsp = "androidx.room:room-compiler:${Versions.Jetpack.Room}"
        const val Hilt = "com.google.dagger:hilt-android-compiler:${Versions.Jetpack.Hilt}"
    }

    object Test {
        val Local = listOf(
            "junit:junit:${Versions.Test.JUnit}",
            "org.hamcrest:hamcrest:${Versions.Test.Hamcrest}",
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Test.Coroutine}"
        )
        const val ComposeUI = "androidx.compose.ui:ui-test-junit4:${Versions.Compose.Main}"
    }

    object Debug {
        const val LeakCanary =
            "com.squareup.leakcanary:leakcanary-android:${Versions.Util.LeakCanary}"
        val Compose = listOf(
            "androidx.compose.ui:ui-tooling:${Versions.Compose.Main}",
            "androidx.compose.ui:ui-test-manifest:${Versions.Compose.Main}"
        )
    }
}
