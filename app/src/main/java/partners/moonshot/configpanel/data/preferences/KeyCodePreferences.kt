package partners.moonshot.configpanel.data.preferences

import android.content.Context
import android.content.SharedPreferences
import partners.moonshot.configpanel.R
import partners.moonshot.configpanel.ui.designsystem.joystick.JoystickKeyEvent
import partners.moonshot.configpanel.ui.konami.KeyEventCode
import javax.inject.Inject

class KeyCodePreferences @Inject constructor(context: Context) {
    companion object {
        const val SOUND_KEY = "sound_key"
        const val JOYSTICK_KEY = "joystick_key"
    }

    private var prefs: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    fun saveKey(newSoundKey: List<KeyEventCode>?, newJoystickKey: List<JoystickKeyEvent>?) {
        val editor = prefs.edit()
        newSoundKey?.let {
            editor.putString(SOUND_KEY, newSoundKey.toString())
        }
        newJoystickKey?.let {
            editor.putString(JOYSTICK_KEY, newJoystickKey.toString())
        }
        editor.apply()
    }

    fun getSoundKey(): String {
        return prefs.getString(SOUND_KEY, "") ?: ""
    }

    fun getJoistickKey(): String {
        return prefs.getString(JOYSTICK_KEY, "") ?: ""
    }
}