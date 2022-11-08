package partners.moonshot.configpanel

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import partners.moonshot.configpanel.ui.designsystem.joystick.JoystickComponent
import partners.moonshot.configpanel.ui.konami.KonamiCodeActivity
import partners.moonshot.configpanel.ui.theme.ConfigPanelTheme


@AndroidEntryPoint
class SampleActivity : KonamiCodeActivity() {


    override fun launchSecretScreen() {
        Toast.makeText(this, "Konami OK", Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConfigPanelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /*ConfigPanelScreen(
                        modifier = Modifier.fillMaxSize()
                    ) { newCode ->
                        setKonamiKey(newCode)
                    }*/
                    JoystickComponent(modifier = Modifier.fillMaxSize()) {

                    }
                }
            }
        }
    }
}
