package partners.moonshot.configpanel.domain

import partners.moonshot.configpanel.ui.designsystem.joystick.JoystickKeyEvent
import partners.moonshot.configpanel.ui.konami.KeyEventCode

data class ConfigPanel(
    val version: String? = "",
    val name: String? = "",
    val configToggles: List<ConfigToggle>? = emptyList(),
    val featureToggles: List<Toggle>? = emptyList(),
    val joystickKeyCode: List<JoystickKeyEvent>? = emptyList(),
    val konamiKeyCode: List<KeyEventCode>? = emptyList()
) {
    companion object {
        fun empty(): ConfigPanel {
            return ConfigPanel("", "", emptyList(), emptyList(), emptyList())
        }
    }
}

