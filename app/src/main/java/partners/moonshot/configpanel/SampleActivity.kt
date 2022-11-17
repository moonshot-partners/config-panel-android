package partners.moonshot.configpanel

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import partners.moonshot.configpanel.ui.designsystem.joystick.JoystickComponent
import partners.moonshot.configpanel.ui.designsystem.joystick.JoystickKeyEvent
import partners.moonshot.configpanel.ui.designsystem.joystick.JoystickKeyEvent.START
import partners.moonshot.configpanel.ui.designsystem.joystick.JoystickScreen
import partners.moonshot.configpanel.ui.konami.KonamiCodeActivity
import partners.moonshot.configpanel.ui.screen.ConfigPanelScreen
import partners.moonshot.configpanel.ui.theme.ConfigPanelTheme


@AndroidEntryPoint
class SampleActivity : KonamiCodeActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConfigPanelTheme {
                Text("Hello World")
            }
        }
    }
}
