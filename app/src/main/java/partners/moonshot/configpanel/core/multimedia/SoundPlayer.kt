package partners.moonshot.configpanel.core.multimedia

import android.content.Context
import android.media.MediaPlayer

class SoundPlayer(
    context: Context,
    uri: Int
) {
    private val mediaPlayer: MediaPlayer = MediaPlayer.create(context, uri)

    fun play(){
        mediaPlayer.start()
    }

    fun stop(){
        mediaPlayer.stop()
    }
}
