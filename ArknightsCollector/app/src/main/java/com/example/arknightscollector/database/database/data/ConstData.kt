package com.example.arknightscollector.database.database.data

val professionList = listOf("近卫", "狙击", "重装", "医疗", "辅助", "术师", "特种", "先锋")
val positionList = listOf("近战位", "远程位")
val rarityList = listOf("高级资深干员", "资深干员", "新手")
val tagList = listOf(
    "支援机械",
    "控场",
    "爆发",
    "治疗",
    "支援",
    "费用回复",
    "输出",
    "生存",
    "群攻",
    "防护",
    "减速",
    "削弱",
    "快速复活",
    "位移",
    "召唤",
    "元素"
)

val filterBtnTitleList = listOf("职业", "位置", "资历", "词缀")
val filterBtnContentList = listOf(professionList, positionList, rarityList, tagList)

enum class ConstData {
    PROFESSION, POSITION, RARITY, TAG
}