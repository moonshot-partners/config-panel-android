package partners.moonshot.configpanel.ui.konami

import android.content.Intent
import android.os.SystemClock
import android.util.Log
import android.view.KeyEvent
import androidx.activity.ComponentActivity
import partners.moonshot.configpanel.BuildConfig
import partners.moonshot.configpanel.ui.designsystem.joystick.JoystickActivity

abstract class KonamiCodeActivity : ComponentActivity() {
    private val konamiCodeChecker = KonamiCodeChecker()

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

    protected fun setKonamiKey(code: List<KeyEventCode>) {
        konamiCodeChecker.setKonamiCode(code = code)
    }

    private fun launchSecretScreen() {
        startActivity(Intent(this, JoystickActivity::class.java))
    }
}