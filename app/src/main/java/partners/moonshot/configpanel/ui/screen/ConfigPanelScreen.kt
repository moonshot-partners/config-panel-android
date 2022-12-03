package partners.moonshot.configpanel.ui.screen

import androidx.activity.compose.BackHandler
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
import partners.moonshot.configpanel.ui.designsystem.flag.FeatureToggleComponent

@Composable
fun ConfigPanelScreen(
    modifier: Modifier = Modifier,
    configPanelViewModel: ConfigPanelViewModel = hiltViewModel(),
    closeConfigPanel: () -> Unit
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
                        item {
                            FeatureToggleComponent(
                                name = featureToggle.name ?: "",
                                isOnFeature = featureToggle.isEnabled ?: false,
                                onClickComponent = {}
                            )
                        }
                    }
                    configToggles?.forEach { configToggle ->
                        item {
                            FeatureToggleComponent(
                                name = configToggle.name ?: "",
                                isOnFeature = configToggle.isEnabled ?: false,
                                onClickComponent = {}
                            )
                        }
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
                    safePanelState.configPanel.konamiKeyCode
                }
            }
        }, state = rememberLazyListState()
    )
    BackHandler {
        closeConfigPanel()
    }
}