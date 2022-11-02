package partners.moonshot.configpanel.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import partners.moonshot.configpanel.domain.ConfigPanel
import partners.moonshot.configpanel.domain.GetConfigPanel
import javax.inject.Inject

@HiltViewModel
class ConfigPanelViewModel @Inject constructor(
    private val getConfigPanel: GetConfigPanel
) : ViewModel() {

    private val mutableState = MutableStateFlow(ConfigPanelState())

    fun state() = mutableState.asStateFlow()

    init {
        viewModelScope.launch {
            mutableState.value = mutableState.value.copy(isLoading = true)
            try{
                getConfigPanel.invoke().also { getConfigPanel ->
                    mutableState.value = mutableState.value.copy(
                        isLoading = false,
                        configPanel = getConfigPanel,
                        errorMessage = null
                    )
                }
            } catch (e: Exception){
                mutableState.value = mutableState.value.copy(
                    isLoading = false,
                    errorMessage = e.message
                )
            }

        }
    }
}