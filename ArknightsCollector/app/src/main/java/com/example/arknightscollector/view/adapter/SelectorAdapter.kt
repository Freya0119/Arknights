package com.example.arknightscollector.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arknightscollector.databinding.ItemBtnBinding
import com.example.arknightscollector.viewModel.DataCollectorViewModel

class SelectorAdapter(private val wordList: List<String>, val selectorViewModel: DataCollectorViewModel) : RecyclerView.Adapter<SelectorAdapter.SelectorViewHolder>() {

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

    inner class SelectorViewHolder(val bind: ItemBtnBinding) : RecyclerView.ViewHolder(bind.root), BtnOnClick {
        override fun onClick() {
            // TODO: set word to who
        }

        fun bind(word: String) {
            selectorViewModel.setWord(word)
        }
    }
}

interface BtnOnClick {
    fun onClick()
}