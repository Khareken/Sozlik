package com.example.sozlik.ui.splash

import com.example.sozlik.data.WordsDao
import com.example.sozlik.helper.DBHelper
import com.example.sozlik.helper.SharedPreferenceHelper
import com.example.sozlik.helper.helper.AppExecutors

class SplashPresenter(
    private val dao: WordsDao,
    private val preferenceHelper: SharedPreferenceHelper,
    private val gsonHelper: DBHelper,
    private val splashView: SplashView,
    private val appExecutors: AppExecutors
) {
    fun cheking() {
        if (preferenceHelper.isAppFirstLaunched()) {
            appExecutors.diskIo.execute {
                dao.insertData(gsonHelper.getWordsFromLocal())
                preferenceHelper.setAppFirstLaunched()
                appExecutors.mainThread.execute {
                    splashView.goToMainActivity()
                }
            }
        } else {
            splashView.goToMainActivity()
        }
    }
}