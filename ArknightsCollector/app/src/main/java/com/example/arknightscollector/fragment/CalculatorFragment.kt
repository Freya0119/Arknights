package com.example.arknightscollector.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.arknightscollector.databinding.ViewSeletorBinding
import com.example.arknightscollector.adapter.SelectBtnAdapter
import com.example.arknightscollector.viewModel.AvatarFilterViewModel
import androidx.fragment.app.activityViewModels
import com.example.arknightscollector.database.database.data.btnTitleList
import com.example.arknightscollector.database.database.data.positionList
import com.example.arknightscollector.database.database.data.professionList
import com.example.arknightscollector.database.database.data.rarityList
import com.example.arknightscollector.database.database.data.tagList

// TODO: 整理 clickItem name
interface ClickItem {
    fun onClick(tag: String)
}

class CalculatorFragment : Fragment() {

    private var bind: ViewSeletorBinding? = null

    private val avatarFilterViewModel : AvatarFilterViewModel by activityViewModels()

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
            override fun onClick(tag: String) {
                avatarFilterViewModel.setTag(tag)
                Toast.makeText(context, "${avatarFilterViewModel.avatarList.value}", Toast.LENGTH_SHORT).show()
            }
        }

        // TODO: title text
        bind!!.includeLine0.tvTitle.text = btnTitleList[0]
        bind!!.includeLine1.tvTitle.text = btnTitleList[1]
        bind!!.includeLine2.tvTitle.text = btnTitleList[2]
        bind!!.includeLine3.tvTitle.text = btnTitleList[3]
        // TODO: all select, all clear
        // TODO: list1, list2, list3
        bind!!.includeLine0.recyclerView.adapter = SelectBtnAdapter(professionList, clickAddWord)
        bind!!.includeLine1.recyclerView.adapter = SelectBtnAdapter(positionList, clickAddWord)
        bind!!.includeLine2.recyclerView.adapter = SelectBtnAdapter(rarityList, clickAddWord)
        bind!!.includeLine3.recyclerView.adapter = SelectBtnAdapter(tagList, clickAddWord)
    }
}