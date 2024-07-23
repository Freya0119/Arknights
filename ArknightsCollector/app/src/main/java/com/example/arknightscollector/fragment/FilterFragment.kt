package com.example.arknightscollector.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.arknightscollector.viewModel.AvatarFilterViewModel
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.arknightscollector.R
import com.example.arknightscollector.database.database.data.filterBtnContentList
import com.example.arknightscollector.databinding.FilterItemBinding
import com.example.arknightscollector.databinding.FragmentFilterBinding
import io.github.luizgrp.sectionedrecyclerviewadapter.Section
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter

class CalculatorFragment : Fragment() {

    private var bind: FragmentFilterBinding? = null

    private val avatarFilterViewModel: AvatarFilterViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentFilterBinding.inflate(inflater, container, false)
        return bind!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        // TODO: test
    }

    private fun initAdapter() {
//        // TODO: doing
//        val adapter = FilterSectionAdapter()
//        // TODO: section, one? tag: many?
//        adapter.addSection(FilterSection())
//        bind!!.recyclerFilter.adapter = adapter
    }
}

class TestSection() : Section(SectionParameters.builder().build()) {
    override fun getContentItemsTotal(): Int {
        return 3
    }

    override fun getItemViewHolder(view: View?): RecyclerView.ViewHolder {
        return SectionViewHolder(view!!)
    }

    override fun onBindItemViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as SectionViewHolder).onBind()
        val text = (holder as SectionViewHolder).tv?.text
        holder.tv?.text = "${position} ${text}"
    }

    inner class SectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv : TextView? = null
        fun onBind() {
            tv = itemView.findViewById(R.id.tv_test_title)
            tv!!.text = "section title"
        }
    }

    inner class SectionContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var tv : TextView? = null
        fun onBind() {
            tv = itemView.findViewById(R.id.tv_test_content)
            tv!!.text = "section content"
        }
    }
}

//class FilterSectionAdapter : SectionedRecyclerViewAdapter() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return super.onCreateViewHolder(parent, viewType)
//    }
//}
//
//class FilterSection : Section(SectionParameters.builder().build()) {
//    override fun getContentItemsTotal(): Int {
//        return filterBtnContentList.size
//    }
//
//    override fun getItemViewHolder(view: View?): RecyclerView.ViewHolder {
//        // create view holder
//        return MyViewHolder(view)
//    }
//
//    override fun onBindItemViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
////        (holder as MyViewHolder).onBind()
//        if (holder is MyViewHolder) {
//            holder.binging.tvTitle.text = "test"
//        }
//    }
//    // TODO: doing
////    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
////        fun onBind() {
////            // TODO: do something?, setDiffContentSie()
////        }
////        // TODO
////        private fun setDiffContent() {}
////    }
//
//    class MyViewHolder(binging: FilterItemBinding): RecyclerView.ViewHolder(binging.root) {
//        val binging = binging
//    }
//
//
//}

//class FilterAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
//        val bind = FilterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return FilterViewHolder(bind)
//    }
//
//    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
//        holder.onBind(position)
//    }
//
//    override fun getItemCount(): Int {
//        return filterBtnTitleList.size
//    }
//
//    private fun resizeBtn() {}
//
//    class FilterViewHolder(private val bind: FilterItemBinding) : RecyclerView.ViewHolder(bind.root) {
//        fun onBind(position: Int) {
//            bind.tvTitle.text = filterBtnTitleList[position]
//            val adapter = FilterBtnAdapter(filterBtnContentList[position])
//            adapter.setClickItem(object : FilterBtnClicker {
//                override fun onClick(type: String, tag: String) {
//                    // TODO: viewModele
//                }
//            })
//            bind.recyclerFilterBtn.adapter = adapter
//        }
//    }
//}