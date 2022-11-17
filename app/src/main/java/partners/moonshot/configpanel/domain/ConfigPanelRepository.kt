package partners.moonshot.configpanel.domain

interface ConfigPanelRepository {
    fun get(): ConfigPanel
    fun isValidVolumenKey(keyQuery: String): Boolean
    fun isValidJoystickKey(keyQuery: String): Boolean
}