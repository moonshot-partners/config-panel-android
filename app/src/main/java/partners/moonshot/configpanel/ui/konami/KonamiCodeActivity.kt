package partners.moonshot.configpanel.ui.konami

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.KeyEvent
import androidx.activity.ComponentActivity
import dagger.hilt.android.AndroidEntryPoint
import partners.moonshot.configpanel.BuildConfig
import partners.moonshot.configpanel.R
import partners.moonshot.configpanel.core.multimedia.SoundPlayer
import partners.moonshot.configpanel.ui.designsystem.joystick.JoystickActivity
import javax.inject.Inject

@AndroidEntryPoint
open class KonamiCodeActivity : ComponentActivity() {

    @Inject
    lateinit var konamiCodeChecker: KonamiCodeChecker

    private lateinit var successKey: SoundPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        successKey = SoundPlayer(this, R.raw.risa)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        event?.let { safeEvent ->

            Log.d("Konami", "keyCode: $keyCode, event: $event")
            val currentTime = SystemClock.elapsedRealtime()
            val keyEventCode: KeyEventCode = KonamiCodeMapper.keyEventToKeyEventCode(safeEvent)
            if (konamiCodeChecker.stillListening(currentTime)) {
                konamiCodeChecker.addKeyCode(KeyCodeData(currentTime, keyEventCode))
                if (konamiCodeChecker.isKonamiCodeValid()) {
                    konamiCodeChecker.resetAccumulatedCode()
                    if (BuildConfig.DEBUG) {
                        launchSecretScreen()
                    }
                }
            } else {
                konamiCodeChecker.resetAccumulatedCode()
                konamiCodeChecker.addKeyCode(KeyCodeData(currentTime, keyEventCode))
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun launchSecretScreen() {
        successKey.play()
        startActivity(Intent(this, JoystickActivity::class.java))
    }
}