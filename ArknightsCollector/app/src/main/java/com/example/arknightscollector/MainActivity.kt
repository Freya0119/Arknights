package com.example.arknightscollector

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.arknightscollector.databinding.MainActivityBinding
import com.example.arknightscollector.viewModel.AvatarFilterViewModel

class MainActivity : AppCompatActivity() {
    private var bind: MainActivityBinding? = null
    // viewModel 放在 provider 裡面，給 fragment 使用
    private val avatarFilterViewModel: AvatarFilterViewModel by lazy {
        ViewModelProvider(this).get(AvatarFilterViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = MainActivityBinding.inflate(layoutInflater)
        setContentView(bind!!.root)

        avatarFilterViewModel.avatarList.observe(this) { avaList ->
            var name = ""
            avaList.forEach {
                name+= "${it.cn}\n"
            }
//            bind!!.tvMainTitle.text = "Hello,\n${name}!"
//            bind!!.recyclerAvatar.adapter = Adapter()   // now: string
        }
    }
}