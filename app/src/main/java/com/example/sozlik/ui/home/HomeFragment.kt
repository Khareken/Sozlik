package com.example.sozlik.ui.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sozlik.R
import com.example.sozlik.data.WordsDao
import com.example.sozlik.data.WordsDatabase
import com.example.sozlik.data.WordsEntity
import com.example.sozlik.data.list.DictionaryAdapter
import com.example.sozlik.data.list.DictionaryOnClickListener
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeView, DictionaryOnClickListener {

    lateinit var wordsDao: WordsDao
    lateinit var presenter: HomePresenter
    private val mAdapter = DictionaryAdapter(this)


    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wordsDao = WordsDatabase.getInstance(context).wordsDao()
        presenter = HomePresenter(wordsDao, this)
        listHome.adapter = mAdapter
        listHome.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        listHome.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        presenter.getData()


        val searchView: TextView = view.findViewById(R.id.searchView)
        searchView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                mAdapter.setData(wordsDao.getWord("$s%"))
            }

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun setData(models: List<WordsEntity>) {
        mAdapter.setData(models)
    }

    override fun onWordClicked() {
        Toast.makeText(context, "WordClicked", Toast.LENGTH_SHORT).show()
    }
}