package partners.moonshot.configpanel.data.firebase

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import partners.moonshot.configpanel.domain.ConfigPanel
import partners.moonshot.configpanel.domain.Key
import partners.moonshot.configpanel.domain.Toggle
import partners.moonshot.configpanel.ui.konami.KeyEventCode
import javax.inject.Inject


class FirebaseManagerRepository @Inject constructor(
    private val firebaseRemoteConfig: FirebaseRemoteConfig
) {
    var configPanel: ConfigPanel = ConfigPanel.empty()
    private val configs = "configs"
    private val features = "features"
    private val konami = "konami"

    init {
        getFeaturesFromFirebase()
    }

    fun getFeaturesFromFirebase() {
        firebaseRemoteConfig.fetchAndActivate().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                getPanel()
            } else {
                throw RuntimeException("Firebase Remote Config not Work!")
            }
        }
    }

    fun getPanel(): ConfigPanel {
        val gson = GsonBuilder().create()
        val configJson = firebaseRemoteConfig.getString(configs)
        val featuresJson = firebaseRemoteConfig.getString(features)
        val konamiJson = firebaseRemoteConfig.getString(konami)

        val configs: List<Toggle> =
            gson.fromJson(configJson, object : TypeToken<List<Toggle?>?>() {}.type)

        val features: List<Toggle> =
            gson.fromJson(featuresJson, object : TypeToken<List<Toggle?>?>() {}.type)

        val konami: List<KeyEventCode> =
            gson.fromJson<List<Key>?>(konamiJson, object : TypeToken<List<Key?>?>() {}.type)
                .map { key ->
                    when(key.key){
                        "UP" -> KeyEventCode.UP
                        "DOWN" -> KeyEventCode.DOWN
                        else -> KeyEventCode.NOT_FOUND
                    }
                }
                /*.map { value ->
                    when (value.lowercase()) {

                    }
                }*/

        return configPanel.copy(
            configToggles = configs,
            featureToggles = features,
            konamiCodeKey = konami
        )
    }
}