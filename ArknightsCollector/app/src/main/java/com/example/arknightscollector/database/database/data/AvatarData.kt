package com.example.arknightscollector.database.database.data

import com.example.arknightscollector.App
import com.google.gson.Gson

const val JsonUrl = "api-result.json"

class AvatarData {
    companion object {
        val avatars: List<JsonResult.Avatar> by lazy {
            lateinit var jsonStr: String
            App.context.assets.open(JsonUrl).bufferedReader().use {
                jsonStr = it.readText()
            }
            val gsonObj = Gson().fromJson(jsonStr, JsonResult::class.java)
            gsonObj.avatars
        }
    }
}