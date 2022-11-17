package partners.moonshot.configpanel.domain

interface ConfigPanelRepository {
    fun get(): ConfigPanel
    fun getStateFromKeyStore(keyQuery: String): Boolean
}