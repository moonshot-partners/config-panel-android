package partners.moonshot.configpanel.ui.konami

import partners.moonshot.configpanel.data.preferences.KeyCodePreferences
import javax.inject.Inject

class KonamiCodeChecker @Inject constructor(
    private val keyCodePreferences: KeyCodePreferences
) {

    private val DELAY_IN_SECONDS = 3000
    private val accumulated: MutableList<KeyCodeData>

    init {
        accumulated = ArrayList()
    }

    fun addKeyCode(keyCodeData: KeyCodeData) {
        accumulated.add(keyCodeData)
    }

    fun isKonamiCodeValid(): Boolean {
        val accumulatedValue = accumulated.map { it.keyCode }
        return accumulatedValue.toFormatKey() == keyCodePreferences.getSoundKey()
    }

    fun resetAccumulatedCode() {
        accumulated.clear()
    }

    fun stillListening(currentTime: Long): Boolean {
        if (accumulated.isEmpty()) return true
        val timeElapsed = currentTime - accumulated.first().pressedAt
        return timeElapsed < DELAY_IN_SECONDS
    }

}

data class KeyCodeData(
    val pressedAt: Long, val keyCode: KeyEventCode
)

enum class KeyEventCode {
    UP, DOWN, NOT_FOUND
}

private fun List<KeyEventCode>.toFormatKey(): String {
    return this.toString().replace("[", "").replace("]", "").replace(" ", "")
}
