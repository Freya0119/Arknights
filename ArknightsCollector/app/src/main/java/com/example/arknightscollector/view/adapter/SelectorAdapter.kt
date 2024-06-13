package com.example.arknightscollector.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.arknightscollector.databinding.ItemBtnBinding
import com.example.arknightscollector.view.ClickItem

class SelectorAdapter(private val wordList: List<String>, val setWord: ClickItem) : RecyclerView.Adapter<SelectorAdapter.SelectorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectorViewHolder {
        val bind = ItemBtnBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectorViewHolder(bind)
    }

    override fun onBindViewHolder(holder: SelectorViewHolder, position: Int) {
        holder.bind.tv.text = wordList[position]
        holder.bind(wordList[position])
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    inner class SelectorViewHolder(val bind: ItemBtnBinding) : RecyclerView.ViewHolder(bind.root) {
        fun bind(word: String) {
            bind.tv.setOnClickListener {
                Log.e("TEST_TAT", "${word}")
                setWord.onClick(word)
            }
        }
    }
}