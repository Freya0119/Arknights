package com.example.arknightscollector

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.arknightscollector.databinding.ViewSeletorBinding
import com.example.arknightscollector.view.adapter.SelectorAdapter
import com.example.arknightscollector.viewModel.DataCollectorViewModel

class SelectorView constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var  bind : ViewSeletorBinding? = null
    private val selectorViewModel : DataCollectorViewModel? = null

    init {
        bind = ViewSeletorBinding.inflate(LayoutInflater.from(context))
    }

    private fun initViewText() {
        bind!!.includeLine0.tvTitle.text = ""
        // TODO: add list
        if (selectorViewModel != null) {
            val adapter = SelectorAdapter(listOf("AAA", "BBB", "CCC"), selectorViewModel)
            bind!!.includeLine0.recyclerView.adapter = adapter
        }
    }
}