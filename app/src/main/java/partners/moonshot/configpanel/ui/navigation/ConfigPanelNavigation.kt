package partners.moonshot.configpanel.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import partners.moonshot.configpanel.ui.designsystem.DesignSystemScreen
import partners.moonshot.configpanel.ui.designsystem.joystick.JoystickScreen
import partners.moonshot.configpanel.ui.screen.ConfigPanelScreen


@Composable
fun ConfigPanelNavigation(
    isDesignMode: Boolean = false,
    onJoystickVisible: () -> Unit,
    onClose: () -> Unit
) {
    val navController = rememberNavController()
    val startDestination =
        if (isDesignMode) ConfigPanelDestination.DESIGN_SYSTEM.name else ConfigPanelDestination.JOYSTICK.name
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = startDestination
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

        composable(ConfigPanelDestination.DESIGN_SYSTEM.name) {
            DesignSystemScreen()
        }

    }
}

enum class ConfigPanelDestination {
    JOYSTICK, CONFIG_PANEL, DESIGN_SYSTEM
}