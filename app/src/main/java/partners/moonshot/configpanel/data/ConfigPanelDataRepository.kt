package partners.moonshot.configpanel.data

import partners.moonshot.configpanel.BuildConfig
import partners.moonshot.configpanel.data.firebase.FirebaseManagerRepository
import partners.moonshot.configpanel.data.preferences.KeyCodePreferences
import partners.moonshot.configpanel.domain.ConfigPanel
import partners.moonshot.configpanel.domain.ConfigPanelRepository
import javax.inject.Inject

class ConfigPanelDataRepository @Inject constructor(
    private val firebaseManagerRepository: FirebaseManagerRepository
) : ConfigPanelRepository {

    private lateinit var configPanel : ConfigPanel
    init{
        get()
    }

    override fun get(): ConfigPanel {
        configPanel = firebaseManagerRepository.getPanel()
        return configPanel
    }

    override fun isValidVolumenKey(keyQuery: String): Boolean {
        if (BuildConfig.IS_CP_ENABLED && BuildConfig.IS_CP_MODE_LAZY) {
            get()
        }
        return keyQuery == configPanel.konamiKeyCode
    }

    override fun isValidJoystickKey(keyQuery: String): Boolean {
        if (BuildConfig.IS_CP_ENABLED) {
            get()
        }
        return keyQuery == configPanel.joystickKeyCode
    }

    override fun fetch() {
        firebaseManagerRepository.getPanel()
    }
}