package com.example.arknightscollector.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.example.arknightscollector.databinding.ViewSeletorBinding
import com.example.arknightscollector.view.adapter.SelectorAdapter
import com.example.arknightscollector.viewModel.DataCollectorViewModel

class SelectorView : FrameLayout {

    private var bind: ViewSeletorBinding? = null
    private val selectorViewModel by lazy {
        ViewModelProvider(findViewTreeViewModelStoreOwner()!!).get(DataCollectorViewModel::class.java)
    }

    init {
        bind = ViewSeletorBinding.inflate(LayoutInflater.from(context),this, true)
        initViewText()
    }

    private fun initViewText() {

        val clickItem: ClickItem = object : ClickItem {
            override fun onClick(word: String) {
                Toast.makeText(context, "${selectorViewModel.tagLiveData.value?.size}", Toast.LENGTH_SHORT).show()
                selectorViewModel.setWord(word)
            }
        }

        // TODO: title text
        bind!!.includeLine0.tvTitle.text = "TODO"
        // TODO: list1, list2, list3
        val adapter0 = SelectorAdapter(listOf("AAA", "BBB", "CCC"), clickItem)
        bind!!.includeLine0.recyclerView.adapter = adapter0
        val adapter1 = SelectorAdapter(listOf("111", "222", "333"), clickItem)
        bind!!.includeLine1.recyclerView.adapter = adapter1
        val adapter2 = SelectorAdapter(listOf("!!!", "???", "@@@"), clickItem)
        bind!!.includeLine2.recyclerView.adapter = adapter2
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)
}

interface ClickItem{
    fun onClick(word: String)
}