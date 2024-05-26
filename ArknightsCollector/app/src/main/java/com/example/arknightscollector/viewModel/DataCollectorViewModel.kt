package com.example.arknightscollector.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.arknightscollector.database.database.data.PersonDatabase
import com.example.arknightscollector.database.model.Person

class DataCollectorViewModel : ViewModel() {

    private val peopleList = PersonDatabase().getList()

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
}