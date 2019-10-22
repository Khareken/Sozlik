package com.example.sozlik.ui.splash

import com.example.sozlik.data.WordsDao
import com.example.sozlik.helper.DBHelper
import com.example.sozlik.helper.SharedPreferenceHelper

class SplashPresenter(
    private val dao: WordsDao,
    private val preferenceHelper: SharedPreferenceHelper,
    private val gsonHelper: DBHelper,
    private val splashView: SplashView
) {
    fun cheking() {
        if (preferenceHelper.isAppFirstLaunched()) {
            dao.insertData(gsonHelper.getWordsFromLocal())
            preferenceHelper.setAppFirstLaunched()
            splashView.goToMainActivity()
        } else {
            splashView.goToMainActivity()
        }
    }
}