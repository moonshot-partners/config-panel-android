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
import partners.moonshot.configpanel.domain.ConfigPanel
import partners.moonshot.configpanel.domain.ConfigToggle
import partners.moonshot.configpanel.domain.Key
import partners.moonshot.configpanel.domain.Toggle
import partners.moonshot.configpanel.ui.konami.KeyEventCode
import javax.inject.Inject


class FirebaseManagerRepository @Inject constructor(
    private val firebaseRemoteConfig: FirebaseRemoteConfig,
    private val firebaseDatabase: FirebaseDatabase
) {
    private lateinit var database: DatabaseReference

    private val defaultConfigPanel = DefaultValues.getDefaultConfigPanel()

    fun getPanel(): ConfigPanel {

        val myRef = firebaseDatabase.getReference(ROOT_DATABASE)
        var configPanel = defaultConfigPanel
        try {

            myRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val remoteConfigPanel = getRemoteConfigPanelFromDatabase(dataSnapshot)
                    remoteConfigPanel?.let { newConfigPanel ->
                        configPanel = newConfigPanel
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    throw RuntimeException("Firebase Remote Database not Work! Error: $error")
                }
            })

            return configPanel
        } catch (e: Throwable) {
            throw RuntimeException("Error in getPanel : ${e.message}")
        }

    }

    private val configs = "configs"
    private val features = "features"
    private val konami = "konami"

    fun getRemoteConfigPanelFromDatabase(dataSnapshot: DataSnapshot): ConfigPanel? {
        return dataSnapshot.getValue(ConfigPanel::class.java)
    }


}