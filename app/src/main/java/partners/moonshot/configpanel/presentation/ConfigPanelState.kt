package partners.moonshot.configpanel.presentation

import partners.moonshot.configpanel.domain.ConfigPanel

data class ConfigPanelState(
    val isLoading: Boolean = false,
    val configPanel: ConfigPanel = ConfigPanel.empty(),
    val errorMessage: String? = null
)
