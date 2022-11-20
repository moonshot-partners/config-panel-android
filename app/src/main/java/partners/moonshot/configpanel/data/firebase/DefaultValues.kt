package partners.moonshot.configpanel.data.firebase

import partners.moonshot.configpanel.BuildConfig.VERSION_NAME
import partners.moonshot.configpanel.domain.ConfigPanel
import partners.moonshot.configpanel.domain.ConfigToggle
import partners.moonshot.configpanel.domain.Toggle

object DefaultValues {

    fun getDefaultConfigPanel(): ConfigPanel {
        return ConfigPanel(
            name = "Config Panel",
            version = VERSION_NAME,
            configToggles = getDefaultConfigToggles(),
            featureToggles = getDefaultFeaturesToggles()
        )
    }

    private fun getDefaultFeaturesToggles(): List<Toggle> {
        return listOf(
            Toggle(
                name = "App State",
                isEnabled = true,
                updateTimer = 0L
            ),
            Toggle(
                name = "Config Panel",
                isEnabled = true,
                updateTimer = 0L
            )
        )
    }

    private fun getDefaultConfigToggles(): List<ConfigToggle> {
        return listOf(
            ConfigToggle(
                name = "Force Server Error Mode",
                isEnabled = false
            ),
            ConfigToggle(
                name = "Force Internet Error Mode",
                isEnabled = false
            ),
            ConfigToggle(
                name = "Sample Mode",
                isEnabled = true
            )
        )
    }
}