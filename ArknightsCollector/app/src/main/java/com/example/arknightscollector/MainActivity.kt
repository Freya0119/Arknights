package com.example.arknightscollector

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.arknightscollector.databinding.MainActivityBinding
import com.example.arknightscollector.view.adapter.BtnAdapterVertical
import com.example.arknightscollector.viewModel.DataCollectorViewModel

class MainActivity : ComponentActivity() {
    private var bind: MainActivityBinding? = null

    private val collectorViewModel: DataCollectorViewModel = DataCollectorViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = MainActivityBinding.inflate(layoutInflater)
        setContentView(bind!!.root)

        // TODO: adapter? button view
        val adapter = BtnAdapterVertical()
        bind?.recyclerView!!.adapter = adapter

        collectorViewModel.tagLiveData.observe(this) { people ->
            var str = ""
            people.forEach {
                str+= "\n${it.name}"
            }
            bind!!.tvTitle.text = "Hello, ${str}!"
        }
    }
}