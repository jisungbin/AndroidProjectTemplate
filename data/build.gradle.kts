plugins {
    id("com.android.library")
    id("kotlin-android")
    id("com.google.devtools.ksp") version Versions.Ksp
}

kotlin {
    sourceSets.main {
        kotlin.srcDir("build/generated/ksp/main/kotlin")
    }
}

ksp {
    arg("room.schemaLocation", "$projectDir/schemas")
}

dependencies {
    /*Dependencies.Login.forEach(::implementation)
    Dependencies.Jackson.forEach(::implementation)
    Dependencies.Network.forEach(::implementation)

    implementationProject(ProjectConstants.Domain)
    implementationProject(ProjectConstants.SharedDomain)

    implementation(Dependencies.Ksp)
    implementation(Dependencies.Jetpack.Room)
    implementation(platform(Dependencies.FirebaseBom))
    implementation(Dependencies.FirebaseEachKtx.Storage)

    ksp(Dependencies.Compiler.RoomKsp)*/
}
