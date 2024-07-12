package com.example.arknightscollector.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.arknightscollector.databinding.ViewSeletorBinding
import com.example.arknightscollector.adapter.SelectBtnAdapter
import com.example.arknightscollector.viewModel.CalculatorViewModel
import androidx.fragment.app.activityViewModels

// TODO: 整理 clickItem name
interface ClickItem {
    fun onClick(word: String)
}

class CalculatorFragment : Fragment() {

    private var bind: ViewSeletorBinding? = null

    private val viewModel : CalculatorViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bind = ViewSeletorBinding.inflate(inflater, container, false)
        return bind!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        resizeView()
        initAdapter()
    }

    private fun resizeView() {
        // TODO: 3. button大小?
    }

    private fun initAdapter() {
        val clickAddWord: ClickItem = object : ClickItem {
            override fun onClick(word: String) {
                viewModel.setTag(word)
                Toast.makeText(context, "${viewModel.opeFilterList.value?.size}", Toast.LENGTH_SHORT).show()
            }
        }

        // TODO: title text
        bind!!.includeLine0.tvTitle.text = "TODO"
        // TODO: list1, list2, list3
        bind!!.includeLine0.recyclerView.adapter = SelectBtnAdapter(listOf("新手", "近衛", "遠程位", "000", "111"), clickAddWord)
        bind!!.includeLine1.recyclerView.adapter = SelectBtnAdapter(listOf("削弱", "222", "333"), clickAddWord)
        bind!!.includeLine2.recyclerView.adapter = SelectBtnAdapter(listOf("!!!", "???", "@@@"), clickAddWord)
    }
}