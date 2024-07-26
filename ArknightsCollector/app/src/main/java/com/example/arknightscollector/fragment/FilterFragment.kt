package com.example.arknightscollector.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.arknightscollector.viewModel.AvatarFilterViewModel
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.arknightscollector.adapter.FilterBtnAdapter
import com.example.arknightscollector.adapter.FilterClicker
import com.example.arknightscollector.database.database.data.filterBtnContentList
import com.example.arknightscollector.database.database.data.filterBtnTitleList
import com.example.arknightscollector.databinding.FilterItemBinding
import com.example.arknightscollector.databinding.FragmentFilterBinding

class CalculatorFragment : Fragment() {

    private var bind: FragmentFilterBinding? = null

    private val avatarFilterViewModel: AvatarFilterViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        bind = FragmentFilterBinding.inflate(inflater, container, false)
        return bind!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
    }

    private fun initAdapter() {
        // TODO: adapter
        bind!!.recyclerFilter.adapter = FilterAdapter(object : FilterClicker {
            override fun onClick(tag: String) {
                avatarFilterViewModel.setTag(tag)
            }
        })
    }
}

class FilterAdapter(private val filterClicker: FilterClicker) : RecyclerView.Adapter<FilterAdapter.SectionHolder>() {
    private val title = filterBtnTitleList
    private val content = filterBtnContentList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionHolder {
        val binding = FilterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SectionHolder(binding)
    }

    override fun onBindViewHolder(holder: SectionHolder, position: Int) {
        holder.binding.tvTitle.text = title[position]
        val adapter = FilterBtnAdapter(content[position])
        adapter.setClickItem(filterClicker)
        holder.binding.recyclerFilterBtn.adapter = adapter
    }

    override fun getItemCount(): Int {
        return title.size
    }

    class SectionHolder(val binding: FilterItemBinding) : RecyclerView.ViewHolder(binding.root)
}