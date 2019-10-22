package com.example.sozlik.data.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sozlik.R
import com.example.sozlik.data.WordsEntity
import kotlinx.android.synthetic.main.fragment_home.view.*

class DictionaryAdapter(private val dictionaryOnClickListener: DictionaryOnClickListener):RecyclerView.Adapter<DictionaryViewHolder>() {

    private var models: List<WordsEntity> = arrayListOf()

    fun setData(models: List<WordsEntity>){
        this.models = models
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DictionaryViewHolder {
   val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return DictionaryViewHolder(itemView)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: DictionaryViewHolder, position: Int) {
        holder.populateModel(models[position],dictionaryOnClickListener)
    }
}