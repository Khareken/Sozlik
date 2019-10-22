package com.example.sozlik.data.list

import android.text.Html
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sozlik.R
import com.example.sozlik.data.WordsEntity

class DictionaryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val word: TextView = itemView.findViewById(R.id.listWordName)
    private val translation: TextView = itemView.findViewById(R.id.listWordTranslation)

    fun populateModel(model: WordsEntity, dictionaryOnClickListener: DictionaryOnClickListener){
        word.text = model.word
        translation.text = Html.fromHtml(model.translation)

        itemView.setOnClickListener {
            dictionaryOnClickListener.onWordClicked()
        }
    }
}