package partners.moonshot.configpanel.data

import partners.moonshot.configpanel.BuildConfig
import partners.moonshot.configpanel.data.firebase.FirebaseManagerRepository
import partners.moonshot.configpanel.data.preferences.KeyCodePreferences
import partners.moonshot.configpanel.domain.ConfigPanel
import partners.moonshot.configpanel.domain.ConfigPanelRepository
import javax.inject.Inject

class ConfigPanelDataRepository @Inject constructor(
    private val keyCodePreferences: KeyCodePreferences,
    private val firebaseManagerRepository: FirebaseManagerRepository
) : ConfigPanelRepository {

    private var isConfigPanelCalled = false

    override fun get(): ConfigPanel {
        isConfigPanelCalled = true
        return firebaseManagerRepository.getPanel().also { configPanel ->
            keyCodePreferences.saveKey(configPanel.konamiKeyCode, configPanel.joystickKeyCode)
        }
    }

    override fun isValidVolumenKey(keyQuery: String): Boolean {
        if(BuildConfig.IS_CP_ENABLED && isConfigPanelCalled.not() && BuildConfig.IS_CP_MODE_LAZY){
            get()
        }
        return keyQuery == keyCodePreferences.getSoundKey()
    }

    override fun isValidJoystickKey(keyQuery: String): Boolean {
        if(isConfigPanelCalled.not()){
            get()
        }
        return keyQuery == keyCodePreferences.getJoistickKey()
    }

}