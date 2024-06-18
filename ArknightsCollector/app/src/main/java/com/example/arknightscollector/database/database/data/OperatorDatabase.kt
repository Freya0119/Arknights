package com.example.arknightscollector.database.database.data

import com.example.arknightscollector.database.model.Person

class OperatorDatabase {
    private val dataList = listOf(
        Person("name", "新手", "近衛", "遠程位", "削弱"),
        Person("name1", "新手", "近衛", "遠程位", "削弱"),
        Person("name2", "新手", "近衛", "遠程位", "削弱"),
        Person("caster1", "新手", "術師", "遠程位", "削弱"),
        Person("caster2", "新手", "術師", "遠程位", "削弱"),
    )

    fun getList(): List<Person> {
        return dataList
    }
}