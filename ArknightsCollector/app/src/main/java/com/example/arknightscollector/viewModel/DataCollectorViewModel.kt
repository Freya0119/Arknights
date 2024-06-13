package com.example.arknightscollector.viewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.arknightscollector.database.database.data.PersonDatabase

class DataCollectorViewModel : ViewModel() {
    // 資料庫，全幹員
    private val peopleList = PersonDatabase().getList()
    // 資歷
    private var experienceList = mutableListOf<String>()
    // 職業
    private var jobList = mutableListOf<String>()
    // 位置
    private var positionList = mutableListOf<String>()
    // 詞綴
    private var tagList = mutableListOf<String>()
    // 詞綴，最多5
    private val _tagLiveData: MutableLiveData<MutableList<String>> = MutableLiveData()
    val tagLiveData get() = _tagLiveData

    fun setWord(word: String) {
        if (!_tagLiveData.value.isNullOrEmpty()) {
            if (_tagLiveData.value!!.size < 5) {
                _tagLiveData.value!!.add(word)
            }
        }
    }
    // 詞綴組合？
    fun createWordLists(){}
}