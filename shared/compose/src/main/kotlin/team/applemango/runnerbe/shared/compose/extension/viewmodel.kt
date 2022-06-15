package team.applemango.runnerbe.shared.compose.extension

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import team.applemango.runnerbe.shared.compose.optin.LocalActivityUsageApi

@LocalActivityUsageApi
@Composable
inline fun <reified VM : ViewModel> activityViewModel(
    key: String? = null,
    factory: ViewModelProvider.Factory? = null,
): VM = viewModel(
    VM::class.java,
    LocalActivity.current,
    key,
    factory
)
