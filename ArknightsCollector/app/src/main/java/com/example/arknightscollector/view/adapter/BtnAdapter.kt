package com.example.arknightscollector.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

// TODO: Header, content
class BtnVerticalAdapter: RecyclerView.Adapter<BtnViewHolder>() {
    private val btn = listOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BtnViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BtnViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return btn.size
    }
}

class BtnHorizontalAdapter: RecyclerView.Adapter<BtnViewHolder>() {
    private val btn= listOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BtnViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BtnViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return btn.size
    }
}

class BtnViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)