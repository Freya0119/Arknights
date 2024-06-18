package com.example.arknightscollector.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arknightscollector.databinding.ItemBtnBinding
import com.example.arknightscollector.fragment.ClickItem

class SelectBtnAdapter(private val wordList: List<String>, val setWord: ClickItem) : RecyclerView.Adapter<SelectBtnAdapter.SelectorViewHolder>() {

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
                setWord.onClick(word)
            }
        }
    }
}