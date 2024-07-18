package com.example.arknightscollector.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.arknightscollector.database.database.data.AvatarData
import com.example.arknightscollector.database.database.data.JsonResult

class AvatarFilterViewModel : ViewModel() {
    // TODO: 沒有圖片
    // .info: 所有干員資料
    private val avatarData = AvatarData.avatars.map { it.info }.filter { it.obtainMethod.contains("公开招募") }
    // 選出來的 詞綴\詞綴組合
    private var tagList = listOf<String>()
    var tagComb: List<List<String>> = listOf()
    // 通過詞綴和詞綴組合篩選的干員
    private val _avatarList = MutableLiveData<List<JsonResult.Avatar.Info>>(listOf())
    val avatarList: LiveData<List<JsonResult.Avatar.Info>> get() = _avatarList

    fun setTag(tag: String) {
        val tempList = tagList.toMutableList()
        if (tagList.size < 5) {
            tempList.add(tag)
            tagList = tempList
        }
        // LiveData的話省略update?
        getTagList()
        getFilterOperatorList()
    }

    fun removeTag(tag: String) {}

    private fun getTagList() {
        val tempTagCombList = mutableListOf<List<String>>()
        for (i in tagList.indices) {
            // add(single)
            tempTagCombList.add(listOf(tagList[i]))
            // add(single + subList)
            for (j in i + 1..tagList.lastIndex) {
                // subList(from, to-1)
                for (z in j + 1..tagList.lastIndex + 1) {
                    tempTagCombList.add(listOf(tagList[i]) + tagList.subList(j, z))
                }
            }
        }
        tagComb = tempTagCombList   // TODO: show內容
    }

    // 根據詞綴篩選幹員
    private fun getFilterOperatorList() {
        val avatarFilterList = avatarData.filter { info ->
            isHadAvatar(info)
        }
        _avatarList.value = avatarFilterList
        // TODO: more tag
//        tagComb.forEach { tagList ->
//            tagList.forEach {
//                // filter
//            }
//        }
    }

    private fun isHadAvatar(info: JsonResult.Avatar.Info): Boolean {
        var isHad = false
        tagList.forEach { tag ->
            // tag = "费用回复 快速复活", 中間有空格
            if (info.profession.contains(tag) || info.position.contains(tag) || info.tag.contains(tag)) {
                isHad = true
                return@forEach
            }
        }
        return isHad
    }
    fun clearTag(type: String) {}
    fun clearAllTag() { }
    // --------------------------------------------------------------------
//    // TODO: 另一種寫法
//    fun removeTag(type: String, tag: String) {
//        // all: tag1.clear() tag2.clear() tag3.clear() tag4.clear()
//        if (isHadTag(type, tag)) {
//            allTag.remove(tag)
//        }
//        calTag()
//    }
//    fun addTag(type: String, tag: String) {
//        if (isHadTag(type, tag)) {
//            allTag.add(tag)
//        }
//        calTag()
//    }
//    fun isHadTag(type: String, tag: String):Boolean {
//        when(type) {
//            "1" -> { return tag1.contains(tag) }
//            "2" -> { return tag2.contains(tag) }
//            "3" -> { return tag3.contains(tag) }
//            "4" -> { return tag4.contains(tag) }
//        }
//    }
//    fun calTag() {
//        allTag.calTagList()
//        // ---------------------------------------------------------------------
//        val singleTagList= tag.spilt(' ')   // 切分空格
//    }
//    fun calAva(type: String, tag: String) {
//        val temp = arrayListOf<JsonResult.Avatar.Info>()
//        avatarData.forEach {
//            when(type) {
//                "1" -> { if (it.position.contains(tag)){
//                    temp.add(it)
//                } }
//                "2" -> { tag2.add() }
//                "3" -> { tag3.add() }
//                "4" -> { tag4.add() }
//            }
//        }
//        _avatarList.value = temp
//    }
}