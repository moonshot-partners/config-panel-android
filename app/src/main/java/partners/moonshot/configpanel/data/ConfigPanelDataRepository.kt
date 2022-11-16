package partners.moonshot.configpanel.data

import kotlinx.coroutines.flow.Flow
import partners.moonshot.configpanel.data.firebase.FirebaseManagerRepository
import partners.moonshot.configpanel.domain.ConfigPanel
import partners.moonshot.configpanel.domain.ConfigPanelRepository
import javax.inject.Inject

class ConfigPanelDataRepository @Inject constructor(
    private val firebaseManagerRepository: FirebaseManagerRepository
) : ConfigPanelRepository {

    override suspend fun get(): Flow<ConfigPanel> {
        return firebaseManagerRepository.getPanel()
    }

    override suspend fun getStateFromKeyStore(keyQuery: String): Boolean {
        return keyQuery == "B,B,A,A"
    }
}