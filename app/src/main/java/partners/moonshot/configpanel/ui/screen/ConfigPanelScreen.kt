package partners.moonshot.configpanel.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import partners.moonshot.configpanel.presentation.ConfigPanelViewModel
import partners.moonshot.configpanel.ui.designsystem.joystick.JoystickViewModel
import partners.moonshot.configpanel.ui.konami.KeyEventCode

@Composable
fun ConfigPanelScreen(
    modifier: Modifier = Modifier,
    configPanelViewModel: ConfigPanelViewModel = hiltViewModel(),
    joystickViewModel: JoystickViewModel = hiltViewModel(),
    konamiKey: (String) -> Unit
) {
    var message by remember {
        mutableStateOf("")
    }

    val state by configPanelViewModel.state().observeAsState()

    LazyColumn(
        modifier = modifier.fillMaxSize(), content = {
            state?.let { safePanelState ->
                with(safePanelState.configPanel) {
                    featureToggles?.forEach { featureToggle ->
                        item { Text(text = featureToggle.name ?: "") }
                    }
                    configToggles?.forEach { configToggle ->
                        item { Text(text = configToggle.name ?: "") }
                    }

                    item { Text(text = konamiKeyCode) }
                    
                    item { Text(text = joystickKeyCode) }

                }

                if (safePanelState.error != null) {
                    safePanelState.error.let { safeMessage ->
                        message = safeMessage.name
                    }
                } else {
                    item { Text(text = message) }
                }

                if (safePanelState.configPanel.konamiKeyCode.isNotEmpty()) {
                    safePanelState.configPanel.konamiKeyCode.let { listKonamy ->
                        konamiKey(listKonamy)
                    }
                }
            }
        }, state = rememberLazyListState()
    )


}