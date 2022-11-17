package partners.moonshot.configpanel.data

import kotlinx.coroutines.flow.Flow
import partners.moonshot.configpanel.data.firebase.FirebaseManagerRepository
import partners.moonshot.configpanel.domain.ConfigPanel
import partners.moonshot.configpanel.domain.ConfigPanelRepository
import javax.inject.Inject

class ConfigPanelDataRepository @Inject constructor(
    private val firebaseManagerRepository: FirebaseManagerRepository
) : ConfigPanelRepository {

    override fun get(): ConfigPanel {
        return firebaseManagerRepository.getPanel()
    }

    override fun getStateFromKeyStore(keyQuery: String): Boolean {
        // TODO implementar Flow para esto
        /*configPanelFlow.collect {
            return keyQuery == "B,B,A,A"
        }*/
        return keyQuery == "B,B,A,A"
    }
}