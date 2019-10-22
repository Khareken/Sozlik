package com.example.sozlik.data

import androidx.room.*

@Dao
interface WordsDao {
    @Query("select * from words")
    fun getAllWords(): List<WordsEntity>

    @Query("select * from words where word like :word ")
    fun getWord(word: String): List<WordsEntity>

    @Update
    fun updateData(model: WordsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(models: List<WordsEntity>)

    @Delete
    fun deleteData(model: WordsEntity)

    @Query("select * from words where id like :id")
    fun getWordByID(id: Int): WordsEntity

    @Query("select * from words where isFavorite = :isFavorite")
    fun getFavoriteWords(isFavorite: Boolean): List<WordsEntity>

//    @Query("select * from words where lastAccessed like :lastAccessed")
//    fun getLastAccessedWords(lastAccessed: Long): List<WordsEntity>
}