package com.example.arknightscollector.database.database.data

import android.content.Context
import android.util.Log
import com.example.arknightscollector.data.JSON_TAG
import com.example.arknightscollector.database.model.Operator
import com.google.gson.Gson

const val JsonUrl = "api-result.json"

class AvatarData() {

    companion object {
        var avatars : List<Avatar.CargoQuery>? = null

        fun createList(context: Context) {
            var jsonStr = ""
            context.assets.open(JsonUrl).bufferedReader().use {
                jsonStr = it.readText()
            }

            val gsonObj = Gson().fromJson(jsonStr, Avatar::class.java)
            avatars = gsonObj.avatars
        }
    }
}