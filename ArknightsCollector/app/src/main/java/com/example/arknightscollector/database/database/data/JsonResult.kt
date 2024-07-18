package com.example.arknightscollector.database.database.data

import com.google.gson.annotations.SerializedName

data class JsonResult(
    @SerializedName("cargoquery")
    val avatars: List<Avatar>,
    val warnings: Warnings
) {
    data class Avatar(
        @SerializedName("title")
        val info: Info
    ) {
        data class Info(
            val cn: String,
            val obtainMethod: String,
            val position: String,
            val profession: String,
            val rarity: String,
            val tag: String
        )
    }

    data class Warnings(
        @SerializedName("cargoquery")
        val cargoQuery: InnerCargoQuery
    ) {
        data class InnerCargoQuery(
            @SerializedName("*")
            val warningsText: String
        )
    }
}

const val callApiUrl =
    "https://prts.wiki/api.php?action=cargoquery&format=json&limit=5000&tables=chara,char_obtain&fields=chara.profession,chara.position,chara.rarity,chara.tag,chara.cn,char_obtain.obtainMethod&where=char_obtain.obtainMethod like \"%公开招募%\" AND chara.charIndex>0&join_on=chara._pageName=char_obtain._pageName"
const val callApiUrl2 =
    "https://prts.wiki/api.php?action=cargoquery&format=json&limit=5000&tables=chara,char_obtain&fields=chara.profession,chara.position,chara.rarity,chara.tag,chara.cn,char_obtain.obtainMethod&join_on=chara._pageName=char_obtain._pageName"

//resp = await fetch(`/api.php?${new URLSearchParams({
//    action: "cargoquery",
//    format: "json",
//    tables: "chara,char_obtain",
//    limit: "5000",
//    fields: "chara.profession,chara.position,chara.rarity,chara.tag,chara.cn,char_obtain.obtainMethod",
//    where: 'char_obtain.obtainMethod like "%公开招募%" AND chara.charIndex>0',
//    join_on: "chara._pageName=char_obtain._pageName",
//})}`,)class Avatar : ArrayList<AvatarItem>(){
