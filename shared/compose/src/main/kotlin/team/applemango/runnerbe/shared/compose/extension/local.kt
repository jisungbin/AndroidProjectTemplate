package team.applemango.runnerbe.shared.compose.extension

import androidx.activity.ComponentActivity
import androidx.compose.runtime.staticCompositionLocalOf
import team.applemango.runnerbe.shared.compose.optin.LocalActivityUsageApi

val LocalActivity = staticCompositionLocalOf<ComponentActivity> {
    LocalActivity.current as ComponentActivity
}
