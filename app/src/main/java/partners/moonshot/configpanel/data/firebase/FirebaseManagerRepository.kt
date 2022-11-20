package partners.moonshot.configpanel.data.firebase

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import partners.moonshot.configpanel.BuildConfig
import partners.moonshot.configpanel.data.firebase.DatabaseKeyNames.ROOT_DATABASE
import partners.moonshot.configpanel.data.preferences.KeyCodePreferences
import partners.moonshot.configpanel.domain.ConfigPanel
import partners.moonshot.configpanel.domain.ConfigToggle
import partners.moonshot.configpanel.domain.Key
import partners.moonshot.configpanel.domain.Toggle
import partners.moonshot.configpanel.ui.konami.KeyEventCode
import javax.inject.Inject


class FirebaseManagerRepository @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase,
    private val keyCodePreferences: KeyCodePreferences,
) {
    private var configPanel = DefaultValues.getDefaultConfigPanel()
    init {
        fetch()
    }

    fun fetch() {
        val myRef = firebaseDatabase.getReference(ROOT_DATABASE)
        try {
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

    fun getPanel(): ConfigPanel {
        return configPanel
    }

    fun getRemoteConfigPanelFromDatabase(dataSnapshot: DataSnapshot): ConfigPanel? {
        return dataSnapshot.getValue(ConfigPanel::class.java)
    }


}