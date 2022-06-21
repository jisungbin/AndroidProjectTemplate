import io.gitlab.arturbosch.detekt.Detekt
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("io.gitlab.arturbosch.detekt") version Versions.BuildUtil.Detekt
    id("org.jlleitschuh.gradle.ktlint") version Versions.BuildUtil.KtlintPlugin
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.dokka:dokka-base:${Versions.BuildUtil.Dokka}")
        classpath("com.android.tools.build:gradle:${Versions.Essential.Gradle}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.Jetpack.Hilt}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Essential.Kotlin}")
        classpath("com.google.android.gms:oss-licenses-plugin:${Versions.OssLicense.Classpath}")
        classpath("com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:${Versions.Util.SecretsGradlePlugin}")
    }
}

allprojects {
    val detektExcludePath = "**/xml/**"

    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
    }

    afterEvaluate {
        if (project.name != "benchmark") {
            project.apply("$rootDir/gradle/common.gradle")
        }

        detekt {
            buildUponDefaultConfig = true
            toolVersion = Versions.BuildUtil.Detekt
            config.setFrom(files("$rootDir/detekt-config.yml"))
        }

        tasks.withType<Detekt>().configureEach {
            jvmTarget = ApplicationConstants.jvmTarget
            exclude(detektExcludePath)
        }

        tasks.withType<KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = freeCompilerArgs + listOf(
                    "-Xopt-in=kotlin.OptIn",
                    "-Xopt-in=kotlin.RequiresOptIn"
                )
            }
        }
    }

    apply {
        plugin("io.gitlab.arturbosch.detekt")
        plugin("org.jlleitschuh.gradle.ktlint")
    }
}

subprojects {
    // https://github.com/gradle/gradle/issues/4823#issuecomment-715615422
    @Suppress("UnstableApiUsage") // isConfigureOnDemand
    if (gradle.startParameter.isConfigureOnDemand &&
        buildscript.sourceFile?.extension?.toLowerCase() == "kts" &&
        parent != rootProject
    ) {
        generateSequence(parent) { project ->
            project.parent.takeIf { it != rootProject }
        }.forEach { project ->
            evaluationDependsOn(project.path)
        }
    }
}

tasks.register("clean", Delete::class) {
    allprojects.map { it.buildDir }.forEach(::delete)
}

apply {
    from("gradle/projectDependencyGraph.gradle")
}
