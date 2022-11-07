package partners.moonshot.configpanel.data.firebase

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import partners.moonshot.configpanel.data.firebase.DatabaseKeyNames.ROOT_DATABASE
import partners.moonshot.configpanel.domain.ConfigPanel
import javax.inject.Inject


class FirebaseManagerRepository @Inject constructor(
    private val firebaseRemoteConfig: FirebaseRemoteConfig,
    private val firebaseDatabase: FirebaseDatabase
) {
    private lateinit var database: DatabaseReference

    private val defaultConfigPanel = DefaultValues.getDefaultConfigPanel()
    private var configPanel: Flow<ConfigPanel> = getPanelFlowCallback()

    private fun getPanelFlowCallback(): Flow<ConfigPanel> {
        return callbackFlow {
            trySend(defaultConfigPanel).isSuccess
            val myRef = firebaseDatabase.getReference(ROOT_DATABASE)
            try {
                myRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        val remoteConfigPanel = getRemoteConfigPanelFromDatabase(dataSnapshot)
                        remoteConfigPanel?.let {
                            trySend(remoteConfigPanel)
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        throw RuntimeException("Firebase Remote Database not Work! Error: $error")
                    }
                })
            } catch (e: Throwable) {
                close(e)
            }

            /*awaitClose {
                myRef.addValueEventListener(null)
            }*/

        }
    }

    private val configs = "configs"
    private val features = "features"
    private val konami = "konami"

    //init {
    //getFeatureFromDatabaseRealTime()
    //}

    private fun setDefaultDatabase() {
        try {
            database = firebaseDatabase.reference
            database.child(ROOT_DATABASE).setValue(DefaultValues.getDefaultConfigPanel())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /*fun getFeaturesFromRemoteConfig() {
        firebaseRemoteConfig.fetchAndActivate().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                getPanel()
            } else {
                throw RuntimeException("Firebase Remote Config not Work!")
            }
        }
    }*/

    fun getRemoteConfigPanelFromDatabase(dataSnapshot: DataSnapshot): ConfigPanel? {
        return dataSnapshot.getValue(ConfigPanel::class.java)
    }

    fun getPanel(): Flow<ConfigPanel> {
        return configPanel
    }

    /*fun getPanel(): ConfigPanel {
        /*val gson = GsonBuilder().create()
        val configJson = firebaseRemoteConfig.getString(configs)
        val featuresJson = firebaseRemoteConfig.getString(features)
        val konamiJson = firebaseRemoteConfig.getString(konami)

        val configs: List<ConfigToggle> =
            gson.fromJson<List<Toggle>?>(configJson, object : TypeToken<List<Toggle?>?>() {}.type)
                .map {
                    ConfigToggle(
                        name = it.name,
                        isEnabled = it.isEnabled
                    )
                }

        val features: List<Toggle> =
            gson.fromJson(featuresJson, object : TypeToken<List<Toggle?>?>() {}.type)

        val konami: List<KeyEventCode> =
            gson.fromJson<List<Key>?>(konamiJson, object : TypeToken<List<Key?>?>() {}.type)
                .map { key ->
                    when (key.key) {
                        "UP" -> KeyEventCode.UP
                        "DOWN" -> KeyEventCode.DOWN
                        else -> KeyEventCode.NOT_FOUND
                    }
                }
        return configPanel.copy(
            configToggles = configs,
            featureToggles = features,
            konamiKeyCode = konami
        )
*/
        return configPanel
    }*/
}