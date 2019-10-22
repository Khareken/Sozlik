package com.example.sozlik.ui.home

import com.example.sozlik.data.WordsDao

class HomePresenter(private val dao:WordsDao, private val homeView: HomeView) {

    fun getData(){
        homeView.setData(dao.getAllWords())
    }
}