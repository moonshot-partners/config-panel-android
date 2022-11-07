package partners.moonshot.configpanel.domain

import kotlinx.coroutines.flow.Flow

interface ConfigPanelRepository {
    suspend fun get() : Flow<ConfigPanel>
}