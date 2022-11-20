package partners.moonshot.configpanel.presentation

import partners.moonshot.configpanel.core.domain.CustomError
import partners.moonshot.configpanel.domain.ConfigPanel

data class ConfigPanelState(
    val isLoading: Boolean = false,
    val configPanel: ConfigPanel = ConfigPanel.empty(),
    val error: CustomError? = null
)
