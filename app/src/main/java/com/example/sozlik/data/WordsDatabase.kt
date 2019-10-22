package com.example.sozlik.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [WordsEntity::class], version = 1, exportSchema = false)
abstract class WordsDatabase : RoomDatabase() {
    companion object {
      lateinit var INSTANCE: WordsDatabase
        fun getInstance(context: Context): WordsDatabase {
            if (!::INSTANCE.isInitialized) {
                INSTANCE =
                    Room.databaseBuilder(context, WordsDatabase::class.java, "sozlikDatabase")
                        .allowMainThreadQueries().build()
            }
            return INSTANCE
        }
    }
        abstract fun  wordsDao(): WordsDao
}