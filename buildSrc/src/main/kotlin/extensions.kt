import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.plugin.use.PluginDependenciesSpec

@Suppress("ControlFlowWithEmptyBody") // empty if block
fun PluginDependenciesSpec.installPlugins(
    isPresentation: Boolean = false,
    isDFM: Boolean = false,
    scabbard: Boolean = false,
    test: Boolean = false,
    hilt: Boolean = false,
) {
    if (!isPresentation && !isDFM) {
        id("com.android.library")
    }
    if (isDFM) {
        id("com.android.dynamic-feature")
    }
    id("kotlin-android")
    id("kotlin-kapt")
    if (!isDFM && hilt) {
        id("dagger.hilt.android.plugin")
    }
    if (test) {
        id("de.mannodermaus.android-junit5")
    }
    if (scabbard) {
//        id("scabbard.gradle") version Versions.Util.Scabbard
    }
}

fun DependencyHandler.installDependencies(
    isSharedModule: Boolean = false,
    orbit: Boolean = false,
    hilt: Boolean = false,
    compose: Boolean = false,
    test: Boolean = false,
) {
    if (orbit) {
        implementation(Dependencies.Orbit.Main)
    }
    if (!isSharedModule) {
        implementationProject(ProjectConstants.SharedAndroid)
    }
    if (hilt) {
        implementation(Dependencies.Jetpack.Hilt)
        add("kapt", Dependencies.Compiler.Hilt)
    }
    if (compose) {
        Dependencies.Compose.forEach(::implementation)
        Dependencies.Debug.Compose.forEach(::debugImplementation)
        implementationProject(ProjectConstants.SharedCompose)
    }
    if (test) {
        add("testImplementation", Dependencies.Orbit.Test)
        add("testImplementation", Dependencies.Test.JunitApi)
        add("testRuntimeOnly", Dependencies.Test.JunitEngine)
        add("testImplementation", Dependencies.Test.Hamcrest)
        add("testImplementation", Dependencies.Test.Coroutine)
    }
}

fun DependencyHandler.implementationProject(path: String) {
    add("implementation", project(path))
}

@Suppress(
    "OPT_IN_IS_NOT_ENABLED", // OptIn usage
    "UNCHECKED_CAST" // Collection<*> as Collection<Any>
)
@OptIn(ExperimentalStdlibApi::class)
// only List or String or platform enters.
fun List<*>.dependenciesFlatten() = buildList {
    this@dependenciesFlatten.forEach { dependency ->
        checkNotNull(dependency) {
            "dependency $dependency is null."
        }
        when (dependency) {
            is Collection<*> -> addAll(dependency as Collection<Any>)
            else -> add(dependency)
        }
    }
}

private fun DependencyHandler.implementation(dependency: Any) {
    add("implementation", dependency)
}

private fun DependencyHandler.debugImplementation(dependency: Any) {
    add("debugImplementation", dependency)
}

private fun DependencyHandler.project(path: String) =
    project(mapOf(Pair("path", path))) as ProjectDependency
