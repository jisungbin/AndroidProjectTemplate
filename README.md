# AndroidProjectTemplate

Android project template for Me([@jisungbin](https://github.com/jisungbin))

[[Without Clean Architecture]](https://github.com/jisungbin/AndroidBaseComposeTemplate/tree/fb6d0dca590a449dc73f6f2869d2580446b5bdf4)

# Includes

```kotlin
val essential = listOf(
    "androidx.core:core-ktx:${Versions.Essential.Ktx}",
    "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Essential.Coroutines}"
)

val compose = listOf(
    "androidx.compose.ui:ui:${Versions.Compose.Master}",
    "androidx.compose.ui:ui-tooling:${Versions.Compose.Master}",
    "androidx.compose.compiler:compiler:${Versions.Compose.Master}",
    "androidx.compose.material:material:${Versions.Compose.Master}",
    "androidx.activity:activity-compose:${Versions.Compose.Activity}",
    "androidx.compose.runtime:runtime-livedata:${Versions.Compose.Master}",
    "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Compose.Lifecycle}"
)

val ui = listOf(
    "com.google.android.material:material:${Versions.Ui.Material}"
)
```
