package com.example.arknightscollector.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arknightscollector.databinding.FilterBtnItemBinding

interface  FilterClicker {
    fun onClick(tag: String)
}

class FilterBtnAdapter(private val btnList: List<String>) : RecyclerView.Adapter<FilterBtnAdapter.FilterBtnViewHolder>() {

    private var mFilterClicker : FilterClicker? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterBtnViewHolder {
        val binding = FilterBtnItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilterBtnViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilterBtnViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return btnList.size
    }

    fun setClickItem(clicker: FilterClicker) {
        mFilterClicker = clicker
    }

    inner class FilterBtnViewHolder(private val binding: FilterBtnItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(position: Int) {
            val tag = btnList[position]
            binding.tv.text = tag
            binding.tv.setOnClickListener {
                if (mFilterClicker != null) {
                    mFilterClicker!!.onClick(tag)
                }
            }
        }
    }
}