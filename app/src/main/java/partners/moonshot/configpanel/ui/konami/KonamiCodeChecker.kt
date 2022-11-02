package partners.moonshot.configpanel.ui.konami

class KonamiCodeChecker(
    private var konamiCodeKey: List<KeyEventCode> = getDefaultKonamiKey()
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
        return accumulatedValue.toString() == konamiCodeKey.toString()
    }

    fun resetAccumulatedCode() {
        accumulated.clear()
    }

    fun stillListening(currentTime: Long): Boolean {
        if (accumulated.isEmpty()) return true
        val timeElapsed = currentTime - accumulated.first().pressedAt
        return timeElapsed < DELAY_IN_SECONDS
    }

    fun setKonamiCode(code: List<KeyEventCode>){
        this.konamiCodeKey = code
    }

}

fun getDefaultKonamiKey(): List<KeyEventCode> {
    return ArrayList<KeyEventCode>().apply {
        add(KeyEventCode.UP)
        add(KeyEventCode.UP)
        add(KeyEventCode.DOWN)
        add(KeyEventCode.DOWN)
    }
}

data class KeyCodeData(
    val pressedAt: Long, val keyCode: KeyEventCode
)

enum class KeyEventCode {
    UP, DOWN, NOT_FOUND
}
