package com.example.arknightscollector.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arknightscollector.databinding.FilterBtnItemBinding

interface  FilterBtnClicker {
    fun onClick(type: String, tag: String)
}

class FilterBtnAdapter(private val btnList: List<String>) :
    RecyclerView.Adapter<FilterBtnAdapter.FilterBtnViewHolder>() {

        private var mFilterClick : FilterBtnClicker? = null

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

    fun setClickItem(clicker: FilterBtnClicker) {
        mFilterClick = clicker
    }

    inner class FilterBtnViewHolder(private val bind: FilterBtnItemBinding) :
        RecyclerView.ViewHolder(bind.root) {
        fun onBind(position: Int) {
            val btnStr = btnList[position]
            bind.tv.text = btnStr
            bind.tv.setOnClickListener {
                if (mFilterClick != null) {
                    mFilterClick!!.onClick(btnStr, btnStr)
                }
            }
        }
    }
}