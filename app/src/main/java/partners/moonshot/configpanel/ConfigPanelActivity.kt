package partners.moonshot.configpanel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import partners.moonshot.configpanel.core.multimedia.SoundPlayer
import partners.moonshot.configpanel.ui.designsystem.joystick.JoystickScreen
import partners.moonshot.configpanel.ui.designsystem.joystick.ui.theme.ConfigPanelTheme
import partners.moonshot.configpanel.ui.navigation.ConfigPanelNavigation

@AndroidEntryPoint
class ConfigPanelActivity : ComponentActivity() {

    private lateinit var soundPlayer: SoundPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        soundPlayer = SoundPlayer(this, R.raw.excelent)
        setContent {
            ConfigPanelTheme {
                ConfigPanelNavigation(
                    onJoystickVisible = { soundPlayer.play() }
                ) {
                    finish()
                }
            }
        }
    }
}