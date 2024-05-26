package com.example.arknightscollector

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.arknightscollector.databinding.MainActivityBinding
import com.example.arknightscollector.viewModel.DataCollectorViewModel

class MainActivity : ComponentActivity() {
    private var bind: MainActivityBinding? = null

    private val collector: DataCollectorViewModel = DataCollectorViewModel()

    private var type = ""
    private var key = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = MainActivityBinding.inflate(layoutInflater)
        setContentView(bind!!.root)

        // TODO: adapter? button view

        collector.liveData.observe(this) { people ->
            var str = ""
            people.forEach {
                str+= "\n${it.name}"
            }
            bind!!.tvTitle.text = "Hello, ${str}!"
        }

        bind?.btnSaber!!.setOnClickListener {
            val thisButton = "職業"   // TODO: 透過 button 決定 type, key
            val thisButton2 = "近衛"
            type = thisButton
            key = thisButton2
            collector.getList(type, key)
        }

        bind?.btnCaster!!.setOnClickListener {
            val thisButton = "職業"
            val thisButton2 = "術師"
            type = thisButton
            key = thisButton2
            collector.getList(type, key)
        }
    }
}