package com.example.arknightscollector.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arknightscollector.databinding.ItemBtnHorizontalBinding

class BtnAdapterVertical() : RecyclerView.Adapter<BtnAdapterVertical.BtnVerticalViewHolder>() {
    private val btn = listOf<String>("1", "23", "3j", "4o")    // TODO

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BtnVerticalViewHolder {
        val bind = ItemBtnHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BtnVerticalViewHolder(bind)
    }

    override fun onBindViewHolder(holder: BtnVerticalViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount(): Int {
        return btn.size
    }

    inner class BtnVerticalViewHolder(val bind: ItemBtnHorizontalBinding) : RecyclerView.ViewHolder(bind.root) {
        fun onBind() {
            bind.tv.text = btn.get(position)
            bind.recyclerView.adapter = BtnAdapterHorizontal()
        }
    }
}