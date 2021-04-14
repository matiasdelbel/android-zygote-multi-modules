package com.delbel.zygote.testapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.delbel.zygote.testapp.databinding.ScreenMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreen : AppCompatActivity() {

    private lateinit var screenBinding: ScreenMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView()
    }

    private fun setContentView() {
        screenBinding = ScreenMainBinding.inflate(layoutInflater)
        setContentView(screenBinding.root)
    }
}
