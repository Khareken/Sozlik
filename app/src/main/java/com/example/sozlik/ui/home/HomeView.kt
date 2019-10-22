package com.example.sozlik.ui.home

import com.example.sozlik.data.WordsEntity

interface HomeView {
    fun setData(models: List<WordsEntity>)
}