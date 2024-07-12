package com.example.arknightscollector.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.arknightscollector.database.database.data.AvatarData
import com.example.arknightscollector.database.model.Operator

class CalculatorViewModel : ViewModel() {
    // 資料庫，全幹員，不可設定
    private val operatorDataList = AvatarData().getDataList()

    // tag 組合，show
    var tagLists: List<List<String>> = listOf()

    // 篩選幹員，show
    private val _opeFilterList = MutableLiveData<List<Operator>>(listOf())
    val opeFilterList: LiveData<List<Operator>> get() = _opeFilterList

    // 詞綴，最多5, no show
    private var tagList = listOf<String>()

    fun setTag(tag: String) {
        val tempList = tagList.toMutableList()
        if (tagList.size < 5) {
            tempList.add(tag)
            tagList = tempList
        }
        // 詞綴組合
        getTagList()
        // 篩選幹員
        getFilterOperatorList()
    }

    // 組合 tag
    private fun getTagList() {
        val tempList = mutableListOf<List<String>>()
        for (i in tagList.indices) {
            // add(single)
            tempList.add(listOf(tagList[i]))
            // add(single + subList)
            for (j in i + 1..tagList.lastIndex) {
                // subList(from, to-1)
                for (z in j + 1..tagList.lastIndex + 1) {
                    tempList.add(listOf(tagList[i]) + tagList.subList(j, z))
                }
            }
        }
        // TODO: show tagLists
        tagLists = tempList
    }

    // 根據詞綴篩選幹員
    private fun getFilterOperatorList() {
        // TODO: 操作 tagList 篩選幹員(one tag), more
        val filterOperatorList = operatorDataList.filter { ope ->
            findOperator(ope)
        }
        _opeFilterList.value = filterOperatorList
    }

    // TODO: more tag
    private fun findOperator(operator: Operator): Boolean {
        var isHave = false
        tagList.forEach { tag ->
            if (operator.tagList.contains(tag)) {
                isHave = true
                return@forEach
            }
        }
        return isHave
    }

    // 根據幹員排列詞綴
    fun createWordLists() {
        // TODO: get person tag and create list
    }
    // 重置
    fun clear(type: String) {
        when (type) {
            "资历" -> {}
            "职业" -> {}
            "位置" -> {}
            "词缀" -> {}
        }
    }
}