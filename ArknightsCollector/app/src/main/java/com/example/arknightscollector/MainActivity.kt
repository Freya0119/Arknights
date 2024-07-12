package com.example.arknightscollector

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.arknightscollector.data.JSON_TAG
import com.example.arknightscollector.database.database.data.Avatar
import com.example.arknightscollector.databinding.MainActivityBinding
import com.example.arknightscollector.viewModel.CalculatorViewModel
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private var bind: MainActivityBinding? = null
    // viewModel 放在 provider 裡面，給 fragment 使用
    private val collectorViewModel: CalculatorViewModel by lazy {
        ViewModelProvider(this).get(CalculatorViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = MainActivityBinding.inflate(layoutInflater)
        setContentView(bind!!.root)

        collectorViewModel.opeFilterList.observe(this) { opeList ->
            var str = ""
            opeList.forEach {
                str+= "${it.name}\n"
            }
            bind!!.tvMainTitle.text = "Hello, ${str}!"
        }
    }
}