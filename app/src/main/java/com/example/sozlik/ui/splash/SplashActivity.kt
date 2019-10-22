package com.example.sozlik.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sozlik.R
import com.example.sozlik.data.WordsDao
import com.example.sozlik.data.WordsDatabase
import com.example.sozlik.helper.DBHelper
import com.example.sozlik.helper.SharedPreferenceHelper
import com.example.sozlik.ui.main.MainActivity

class SplashActivity : AppCompatActivity(), SplashView {
    private val gsonHelper: DBHelper = DBHelper(this, "sozlik.json")
    lateinit var dao: WordsDao
    lateinit var sharedPreferenceHelper: SharedPreferenceHelper
    lateinit var splashPresenter: SplashPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        dao = WordsDatabase.getInstance(this).wordsDao()
        sharedPreferenceHelper = SharedPreferenceHelper(this)
        splashPresenter = SplashPresenter(dao, sharedPreferenceHelper, gsonHelper, this)
        splashPresenter.cheking()
    }

    override fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}