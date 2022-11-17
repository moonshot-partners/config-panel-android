package partners.moonshot.configpanel.ui.designsystem.joystick

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import partners.moonshot.configpanel.domain.ConfigPanel

@Composable
fun JoystickScreen(
    modifier: Modifier = Modifier,
    joystickViewModel: JoystickViewModel = hiltViewModel(),
    onSuccess: () -> Unit
) {
    Surface(modifier = modifier) {
        val state by joystickViewModel.state().collectAsState()
        JoystickComponent(joystickMonitor = state.joystickMonitor,
            isSuccessState = state.successState,
            onKeyEvent = {
                joystickViewModel.setText(it.name)
            })
        LaunchedEffect(state.successState) {
            val isSuccess = state.successState ?: false
            if (isSuccess) {
                onSuccess()
            }
        }
    }
}