package partners.moonshot.configpanel.ui.designsystem.joystick

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import partners.moonshot.configpanel.domain.ConfigPanelRepository
import partners.moonshot.configpanel.domain.GetConfigPanel
import javax.inject.Inject


class IsValidSoundKey @Inject constructor(
    private val configPanelRepository: ConfigPanelRepository
) {
    operator fun invoke(key: String): Boolean {
        return configPanelRepository.isValidVolumenKey(key)
    }
}

class IsValidJoystickKey @Inject constructor(
    private val configPanelRepository: ConfigPanelRepository
) {
    operator fun invoke(key: String): Boolean {
        return configPanelRepository.isValidJoystickKey(key)
    }
}

@OptIn(FlowPreview::class)
@HiltViewModel
class JoystickViewModel @Inject constructor(
    private val isValidJoystickKey: IsValidJoystickKey
) : ViewModel() {

    private val mutableState = MutableStateFlow(JoystickState())
    fun state() = mutableState.asStateFlow()
    private val mutableTextSearch = MutableStateFlow("")
    private val delayDebounce = 1000L
    private val textSearch: StateFlow<String> = mutableTextSearch.asStateFlow()


    init {
        viewModelScope.launch {
            textSearch.debounce(delayDebounce).collect { query ->
                if (query.isNotBlank()) {
                    mutableState.value =
                        mutableState.value.copy(
                            successState = isValidJoystickKey(query),
                            joystickMonitor = query
                        )
                    mutableTextSearch.value = ""
                }
            }
        }
    }

    fun setText(name: String) {
        mutableTextSearch.value =
            if (mutableTextSearch.value.isEmpty()) name
            else mutableTextSearch.value + "," + name
    }

}

data class JoystickState(
    val joystickMonitor: String = "", val successState: Boolean? = null
)