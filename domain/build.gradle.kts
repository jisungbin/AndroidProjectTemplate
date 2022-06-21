plugins {
    id("com.android.library")
    id("kotlin-android")
    id("org.jetbrains.dokka") version Versions.BuildUtil.Dokka
    id("name.remal.check-dependency-updates") version Versions.BuildUtil.CheckDependencyUpdates
    jacoco
}

jacoco {
    toolVersion = Versions.Test.JaCoCo
}

tasks.withType<JacocoReport> {
    reports {
        html.required.set(true)
        html.outputLocation.set(layout.projectDirectory.dir("../documents/coverage/jacoco/html"))
        xml.required.set(true) // codecov depends on xml format report
        xml.outputLocation.set(layout.projectDirectory.file("../documents/coverage/jacoco/report.xml"))
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    finalizedBy("jacocoTestReport")
}

android {
    namespace = "land.sungbin.androidprojecttemplate.domain"
}

dependencies {
    val projects = listOf(
        ProjectConstants.SharedDomain
    )
    projects.forEach(::projectImplementation)

    Dependencies.Test.Local.forEach(::testImplementation)
}
