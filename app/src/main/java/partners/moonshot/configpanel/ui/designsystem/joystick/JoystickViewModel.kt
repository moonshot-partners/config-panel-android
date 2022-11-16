package partners.moonshot.configpanel.ui.designsystem.joystick

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import partners.moonshot.configpanel.domain.ConfigPanelRepository
import javax.inject.Inject


class GetStateByQueryKey @Inject constructor(
    private val configPanelRepository: ConfigPanelRepository
) {
    suspend operator fun invoke(key: String): Boolean {
        return configPanelRepository.getStateFromKeyStore(key)
    }
}

@OptIn(FlowPreview::class)
@HiltViewModel
class JoystickViewModel @Inject constructor(
    private val getStateByQueryKey: GetStateByQueryKey
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
                            successState = getStateByQueryKey(query),
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