package com.example.arknightscollector.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.arknightscollector.database.database.data.OperatorDatabase

class CalculatorViewModel : ViewModel() {
    // 資料庫，全幹員，不可設定
    private val operatorList = OperatorDatabase().getList()
    // 資歷
    private var experienceList = mutableListOf<String>()
    // 職業
    private var jobList = mutableListOf<String>()
    // 位置
    private var positionList = mutableListOf<String>()
    // 詞綴
    private var tagList = mutableListOf<String>()
    // 詞綴，最多5
    private val _tagLiveData = MutableLiveData<ArrayList<String>>(arrayListOf())
    val tagLiveData get() = _tagLiveData

    fun setTag(tag: String) {
        val tempList = _tagLiveData.value
        if (tagLiveData.value!!.size < 5) {
            tempList?.add(tag)
            _tagLiveData.value = tempList ?: arrayListOf()
        }
    }

    // 根據詞綴篩選幹員
    fun getOperatorList() {
        // TODO: createWordList(), 然後篩選幹員？
        // TODO: 操作 tagList 篩選幹員
    }

    // 根據幹員排列詞綴
    fun createWordLists() {
        // TODO: get person tag and create list
    }
}