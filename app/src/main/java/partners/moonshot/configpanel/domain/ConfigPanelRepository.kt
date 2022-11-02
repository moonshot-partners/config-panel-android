package partners.moonshot.configpanel.domain

interface ConfigPanelRepository {
    suspend fun get() : ConfigPanel
}