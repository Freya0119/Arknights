package com.example.arknightscollector.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.arknightscollector.database.database.data.PersonDatabase
import com.example.arknightscollector.database.model.Person
import com.example.arknightscollector.view.adapter.HolderClick

class DataCollectorViewModel : ViewModel() {

    private val peopleList = PersonDatabase().getList()

    // TODO: hashMap? <key, value>, 把什麼給viewModel
    private var tag1 = 0
    private var tag2 = 0
    // TODO: hashMap.value, max 5, 從 list 撈幹員, tag1不重要?
    private var tagList = mutableListOf<String>()

    private val _liveData: MutableLiveData<List<Person>> = MutableLiveData()
    val liveData get() = _liveData

    fun getList(type: String, key: String) {
        when (type) {
            "資歷" -> { _liveData.value = peopleList.filter { it.experience == key } }
            "職業" -> { _liveData.value = peopleList.filter { it.job == key } }
            "位置" -> { _liveData.value = peopleList.filter { it.position == key } }
            "詞綴" -> { _liveData.value = peopleList.filter { it.word == key } }
            else -> { _liveData.value = emptyList() }
        }
    }

    val clickListener = object : HolderClick {
        override fun onClick(key: String) {
            if (tagList.size < 5) tagList.add(key)
        }
    }
}

// TODO: 換位置
class TagHeaderList {
    val list: List<String> = listOf("資歷", "職業", "位置", "詞綴")
}