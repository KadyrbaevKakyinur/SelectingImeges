package selectingImages.utils

import android.app.Application
import android.content.SharedPreferences

class App : Application() {

    lateinit var prefs: Prefs

    override fun onCreate() {
        super.onCreate()
        val preferences: SharedPreferences=this.applicationContext.getSharedPreferences("settings", MODE_PRIVATE)
        prefs=Prefs(preferences)
    }
}