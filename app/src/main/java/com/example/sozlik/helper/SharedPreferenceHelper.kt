package com.example.sozlik.helper

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceHelper(context: Context) {

    companion object {
        const val IS_APP_FIRST_LAUNCHED = "isAppFirstLaunched"
    }

    val preferences: SharedPreferences =
        context.getSharedPreferences(IS_APP_FIRST_LAUNCHED, Context.MODE_PRIVATE)

    fun isAppFirstLaunched(): Boolean {
        return preferences.getBoolean(IS_APP_FIRST_LAUNCHED, true)
    }

    fun setAppFirstLaunched() {
        preferences.edit().putBoolean(IS_APP_FIRST_LAUNCHED, false).apply()
    }

}