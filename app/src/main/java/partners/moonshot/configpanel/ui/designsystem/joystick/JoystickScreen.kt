package partners.moonshot.configpanel.ui.designsystem.joystick

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun JoystickScreen(
    modifier: Modifier = Modifier,
    joystickViewModel: JoystickViewModel = hiltViewModel()
) {
    Surface(modifier = modifier) {
        val state by joystickViewModel.state().collectAsState()
        JoystickComponent(
            joystickMonitor = state.joystickMonitor,
            isSuccessState = state.successState,
            onKeyEvent = {
                joystickViewModel.setText(it.name)
            }
        )
    }
}