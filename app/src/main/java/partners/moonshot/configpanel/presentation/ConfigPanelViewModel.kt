package partners.moonshot.configpanel.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import partners.moonshot.configpanel.core.domain.getCustomError
import partners.moonshot.configpanel.domain.ConfigPanel
import partners.moonshot.configpanel.domain.GetConfigPanel
import javax.inject.Inject

@HiltViewModel
class ConfigPanelViewModel @Inject constructor(
    private val getConfigPanel: GetConfigPanel
) : ViewModel() {

    private val configLiveData =
        MutableLiveData(ConfigPanelState(isLoading = true))

    fun state(): LiveData<ConfigPanelState> = configLiveData

    init {
        viewModelScope.launch {
            try {
                configLiveData.value = ConfigPanelState(
                    isLoading = false,
                    configPanel = getConfigPanel()
                )
            } catch (e: Exception) {
                configLiveData.value = ConfigPanelState(
                    isLoading = false,
                    error = e.getCustomError()
                )
            }
        }
    }

}

