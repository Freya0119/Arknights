package com.example.arknightscollector.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.arknightscollector.adapter.SelectBtnAdapter
import com.example.arknightscollector.viewModel.AvatarFilterViewModel
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.arknightscollector.adapter.FilterBtnAdapter
import com.example.arknightscollector.database.database.data.filterBtnContentList
import com.example.arknightscollector.database.database.data.filterBtnTitleList
import com.example.arknightscollector.database.database.data.positionList
import com.example.arknightscollector.database.database.data.professionList
import com.example.arknightscollector.database.database.data.rarityList
import com.example.arknightscollector.database.database.data.tagList
import com.example.arknightscollector.databinding.FilterBtnItemBinding
import com.example.arknightscollector.databinding.FilterItemBinding
import com.example.arknightscollector.databinding.FragmentFilterBinding

// TODO: 整理 clickItem name
interface ClickItem {
    fun onClick(tag: String)
}

class CalculatorFragment : Fragment() {

    private var bind: FragmentFilterBinding? = null

    private val avatarFilterViewModel : AvatarFilterViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bind = FragmentFilterBinding.inflate(inflater, container, false)
        return bind!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
    }

    private fun initAdapter() {
//        // TODO: working
        bind.recyclerFilter.adapter = FilterAdapter()
        // ------------------------------------------------------------------
        val clickAddWord: ClickItem = object : ClickItem {
            override fun onClick(tag: String) {
                avatarFilterViewModel.setTag(tag)
                Toast.makeText(context, "${avatarFilterViewModel.avatarList.value}", Toast.LENGTH_SHORT).show()
            }
        }

        // TODO: title text
        bind!!.includeLine0.tvTitle.text = filterBtnTitleList[0]
        bind!!.includeLine1.tvTitle.text = filterBtnTitleList[1]
        bind!!.includeLine2.tvTitle.text = filterBtnTitleList[2]
        bind!!.includeLine3.tvTitle.text = filterBtnTitleList[3]
        // TODO: all select, all clear
        // TODO: list1, list2, list3
        bind!!.includeLine0.recyclerView.adapter = SelectBtnAdapter(professionList, clickAddWord)
        bind!!.includeLine1.recyclerView.adapter = SelectBtnAdapter(positionList, clickAddWord)
        bind!!.includeLine2.recyclerView.adapter = SelectBtnAdapter(rarityList, clickAddWord)
        bind!!.includeLine3.recyclerView.adapter = SelectBtnAdapter(tagList, clickAddWord)
    }
}

class FilterAdapter() : RecyclerView.Adapter<FilterAdapter.FilterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        val bind = FilterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilterViewHolder(bind)
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return filterBtnTitleList.size
    }

    private fun resizeBtn() {}

    class FilterViewHolder(private val bind: FilterItemBinding) : RecyclerView.ViewHolder(bind.root) {
        fun onBind(position: Int) {
            bind.tvTitle.text = filterBtnTitleList[position]
            bind.recyclerFilterBtn.adapter = FilterBtnAdapter(filterBtnContentList[position], null)
        }
    }
}