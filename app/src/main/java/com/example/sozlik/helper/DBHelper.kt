package com.example.sozlik.helper

import android.content.Context
import com.example.sozlik.data.WordsEntity
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class DBHelper(private val context: Context, private val fileName: String) {
    private fun readJsonFromAssets(): String {
        val json: String
        try {
            val inputStream: InputStream = context.assets.open(fileName)
            val size =inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException){
            ex.printStackTrace()
            return ""
        }
          return json
    }
      fun getWordsFromLocal(): List<WordsEntity>{
          val json: String = readJsonFromAssets()
          val listType =object : TypeToken<List<WordsEntity>>(){}.type
          return GsonBuilder().create().fromJson(json,listType)
      }
}