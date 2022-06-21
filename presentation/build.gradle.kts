plugins {
    installPlugins(
        isPresentation = true,
        isDFM = false,
        hilt = false,
    )
    id("com.android.application")
    id("com.google.android.gms.oss-licenses-plugin")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id("name.remal.check-dependency-updates") version Versions.BuildUtil.CheckDependencyUpdates
}

android {
    namespace = "land.sungbin.androidprojecttemplate"

    // TODO: set your signing configs
    /*signingConfigs {
        create("release") {
            storeFile = file(BuildConstants.StoreFilePath)
            storePassword = BuildConstants.StorePassword
            keyAlias = BuildConstants.KeyAlias
            keyPassword = BuildConstants.KeyPassword
        }
    }*/

    defaultConfig {
        versionCode = ApplicationConstants.versionCode
        versionName = ApplicationConstants.versionName
    }

    buildTypes {
        create("benchmark") {
            signingConfig = signingConfigs.getByName("debug")
            matchingFallbacks += listOf("release")
            isDebuggable = false
        }
        debug {
            aaptOptions.cruncherEnabled = false // png optimization (default: true)
        }

        // TODO
        /*release {
            signingConfig = signingConfigs.getByName("release")
        }*/
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.Main
    }
}

dependencies {
    val features = listOf(
        ProjectConstants.SharedAndroid,
    )
    features.forEach(::projectImplementation)

    val dependencies = listOf(
        Dependencies.Ui,
        Dependencies.Analytics,
        Dependencies.EachUtil.Erratum,
    ).dependenciesFlatten()
    dependencies.forEach(::implementation)

    debugImplementation(Dependencies.Debug.LeakCanary)
    installDependencies(
        isSharedModule = false,
        orbit = false,
        hilt = true,
        compose = true,
        test = false
    )
}
