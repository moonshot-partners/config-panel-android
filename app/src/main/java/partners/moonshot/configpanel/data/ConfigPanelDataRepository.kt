package partners.moonshot.configpanel.data

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import partners.moonshot.configpanel.BuildConfig
import partners.moonshot.configpanel.data.firebase.DatabaseKeyNames
import partners.moonshot.configpanel.data.preferences.KeyCodePreferences
import partners.moonshot.configpanel.domain.ConfigPanel
import partners.moonshot.configpanel.domain.ConfigPanelRepository
import javax.inject.Inject

class ConfigPanelDataRepository @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase,
    private val keyCodePreferences: KeyCodePreferences,
) : ConfigPanelRepository {

    private lateinit var configPanel : ConfigPanel
    init{
        fetch()
    }

    override fun get(): ConfigPanel {
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
        try {
            val myRef = firebaseDatabase.getReference(DatabaseKeyNames.ROOT_DATABASE)
            myRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val remoteConfigPanel = getRemoteConfigPanelFromDatabase(dataSnapshot)
                    remoteConfigPanel?.let { newConfigPanel ->
                        configPanel = newConfigPanel.also { configPanel ->
                            keyCodePreferences.saveKey(
                                configPanel.konamiKeyCode,
                                configPanel.joystickKeyCode
                            )
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    throw RuntimeException("Firebase Remote Database not Work! Error: $error")
                }
            })
        } catch (e: Throwable) {
            throw RuntimeException("Error in getPanel : ${e.message}")
        }
    }
    fun getRemoteConfigPanelFromDatabase(dataSnapshot: DataSnapshot): ConfigPanel? {
        return dataSnapshot.getValue(ConfigPanel::class.java)
    }
}