package partners.moonshot.configpanel.domain

import partners.moonshot.configpanel.ui.konami.KeyEventCode

data class ConfigPanel(
    val version: String,
    val name: String,
    val configToggles: List<Toggle>,
    val featureToggles: List<Toggle>,
    val konamiCodeKey: List<KeyEventCode>
) {
    companion object {
        fun empty(): ConfigPanel {
            return ConfigPanel("", "", emptyList(), emptyList(), emptyList())
        }
    }
}

