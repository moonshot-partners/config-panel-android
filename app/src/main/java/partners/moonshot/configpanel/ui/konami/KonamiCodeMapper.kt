package partners.moonshot.configpanel.ui.konami

import android.view.KeyEvent

object KonamiCodeMapper {
    fun keyEventToKeyEventCode(event: KeyEvent): KeyEventCode {
        return when(event.keyCode){
            KeyEvent.KEYCODE_VOLUME_UP -> KeyEventCode.UP
            KeyEvent.KEYCODE_VOLUME_DOWN -> KeyEventCode.DOWN
            else -> KeyEventCode.NOT_FOUND
        }
    }
}
