package partners.moonshot.configpanel.data

import partners.moonshot.configpanel.data.firebase.FirebaseManagerRepository
import partners.moonshot.configpanel.domain.ConfigPanel
import partners.moonshot.configpanel.domain.ConfigPanelRepository
import javax.inject.Inject

class ConfigPanelDataRepository @Inject constructor(
    private val firebaseManagerRepository: FirebaseManagerRepository
) : ConfigPanelRepository {

    override suspend fun get(): ConfigPanel {
        return firebaseManagerRepository.getPanel()
    }

}