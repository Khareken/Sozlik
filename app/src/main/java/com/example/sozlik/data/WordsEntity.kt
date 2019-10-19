package com.example.sozlik.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class WordsEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "word")
    var word: String,

    @ColumnInfo(name = "translation")
    var translation: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)