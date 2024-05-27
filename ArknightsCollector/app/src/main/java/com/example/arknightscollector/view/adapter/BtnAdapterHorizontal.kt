package com.example.arknightscollector.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arknightscollector.databinding.ItemBtnBinding
import com.example.arknightscollector.viewModel.TagHeaderList

// TODO: Header, content
class BtnAdapterHorizontal : RecyclerView.Adapter<BtnAdapterHorizontal.BtnViewHolder>() {
    // TODO: get tag
    private val btn = listOf<String>("AAA", "BBB")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BtnViewHolder {
        val bind = ItemBtnBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BtnViewHolder(bind)
    }

    override fun onBindViewHolder(holder: BtnViewHolder, position: Int) {
        holder.bind.btn.text = btn.get(position)
        holder.itemView.setOnClickListener {  }
    }

    override fun getItemCount(): Int {
        return btn.size
    }

    inner class BtnViewHolder(val bind: ItemBtnBinding) : RecyclerView.ViewHolder(bind.root) { // TODO: click with viewModel
        fun onBind(){}
    }
}

interface HolderClick {
    fun onClick(key: String)
}