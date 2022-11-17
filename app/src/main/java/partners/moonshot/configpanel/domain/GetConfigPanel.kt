package partners.moonshot.configpanel.domain

import javax.inject.Inject

class GetConfigPanel @Inject constructor(
    private val configPanelRepository: ConfigPanelRepository
) {
    operator fun invoke() = configPanelRepository.get()
}