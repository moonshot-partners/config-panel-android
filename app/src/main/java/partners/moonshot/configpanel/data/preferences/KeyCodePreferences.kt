package partners.moonshot.configpanel.data.preferences

import android.content.Context
import android.content.SharedPreferences
import partners.moonshot.configpanel.R
import partners.moonshot.configpanel.data.preferences.KeyCodePreferences.Companion.SOUND_KEY
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

    fun saveKey(newSoundKey: String, newJoystickKey: String) {
        val editor = prefs.edit()
        editor.putString(SOUND_KEY, newSoundKey)
        editor.putString(JOYSTICK_KEY, newJoystickKey)
        editor.apply()
    }

    fun getSoundKey(): String {
        return prefs.getString(SOUND_KEY, "") ?: ""
    }

    fun getJoystickKey(): String {
        return prefs.getString(JOYSTICK_KEY, "") ?: ""
    }
}