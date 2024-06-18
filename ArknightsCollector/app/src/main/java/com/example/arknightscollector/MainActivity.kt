package com.example.arknightscollector

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.arknightscollector.databinding.MainActivityBinding
import com.example.arknightscollector.fragment.CalculatorFragment
import com.example.arknightscollector.viewModel.CalculatorViewModel

const val TEST_TAG = "TEST_TAG"

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

        collectorViewModel.tagLiveData.observe(this) { tags ->
            var str = ""
            tags.forEach {
                str+= "${it}\n"
            }
            bind!!.tvTitle.text = "Hello, ${str}!"
        }
    }
}