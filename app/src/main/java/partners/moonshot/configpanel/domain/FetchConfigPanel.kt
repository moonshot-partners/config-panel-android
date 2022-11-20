package partners.moonshot.configpanel.domain

import javax.inject.Inject

class FetchConfigPanel @Inject constructor(
    private val configPanelRepository: ConfigPanelRepository
) {
    suspend operator fun invoke() = configPanelRepository.fetch()
}