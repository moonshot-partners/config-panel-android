package partners.moonshot.configpanel.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import partners.moonshot.configpanel.presentation.ConfigPanelViewModel
import partners.moonshot.configpanel.ui.konami.KeyEventCode

@Composable
fun ConfigPanelScreen(
    modifier: Modifier = Modifier,
    configPanelViewModel: ConfigPanelViewModel = hiltViewModel(),
    konamiKey: (List<KeyEventCode>) -> Unit
) {
    var message by remember {
        mutableStateOf("")
    }

    val state by configPanelViewModel.state().collectAsState()

    LazyColumn(
        modifier = modifier.fillMaxSize(), content = {
            if (state.isLoading) {
                item { Text(text = "Show Loading") }
            }

            state.configPanel.configToggles.forEach { configToggle ->
                item { Text(text = configToggle.name) }
            }
            with(state.configPanel) {
                featureToggles.forEach { featureToggle ->
                    item { Text(text = featureToggle.name) }
                }

                configToggles.forEach { configToggle ->
                    item { Text(text = configToggle.name) }
                }

                konamiCodeKey.forEach { keyEventCode ->
                    item { Text(text = keyEventCode.name) }
                }

            }

            if (state.errorMessage != message) {
                state.errorMessage?.let { safeMessage ->
                    message = safeMessage
                }
            } else {
                item { Text(text = message) }
                // TODO validar si es necesario marcar en viewModel que no muestre mas el mensaje
            }
        }, state = rememberLazyListState()
    )

    LaunchedEffect(key1 = Unit, block = {
        konamiKey(state.configPanel.konamiCodeKey)
    })
}