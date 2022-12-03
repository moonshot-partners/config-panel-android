package partners.moonshot.configpanel.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import partners.moonshot.configpanel.ui.designsystem.joystick.JoystickScreen
import partners.moonshot.configpanel.ui.screen.ConfigPanelScreen


@Composable
fun ConfigPanelNavigation(onJoystickVisible: () -> Unit, onClose: () -> Unit) {
    val navController = rememberNavController()
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = ConfigPanelDestination.JOYSTICK.name
    ) {

        composable(ConfigPanelDestination.JOYSTICK.name) {
            JoystickScreen {
                onJoystickVisible()
                navController.navigate(ConfigPanelDestination.CONFIG_PANEL.name)
            }
        }

        composable(ConfigPanelDestination.CONFIG_PANEL.name) {
            ConfigPanelScreen {
                onClose()
            }
        }

    }
}

enum class ConfigPanelDestination {
    JOYSTICK, CONFIG_PANEL
}