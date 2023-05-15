package selectingImages.utils

import android.content.SharedPreferences

class Prefs (private val preference:  SharedPreferences) {
    fun saveBoardState(){
        preference.edit().putBoolean("key", true).apply()

    }
    fun isBoardShow(): Boolean{
        return preference.getBoolean("key", false)
    }
}