package com.example.arknightscollector.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arknightscollector.databinding.FilterBtnItemBinding
import com.example.arknightscollector.fragment.ClickItem

class FilterBtnAdapter(private val btnList: List<String>, val setWord: ClickItem) :
    RecyclerView.Adapter<FilterBtnAdapter.FilterBtnViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterBtnViewHolder {
        val bind = FilterBtnItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilterBtnViewHolder(bind)
    }

    override fun onBindViewHolder(holder: FilterBtnViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return btnList.size
    }

    inner class FilterBtnViewHolder(private val bind: FilterBtnItemBinding) :
        RecyclerView.ViewHolder(bind.root) {
        fun onBind(position: Int) {
            val btnStr = btnList[position]
            bind.tv.text = btnStr
            bind.tv.setOnClickListener {
                setWord.onClick(btnStr)
            }
        }
    }
}