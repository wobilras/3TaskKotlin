package com.example.a3taskkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a3taskkotlin.databinding.MainActivityBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        CoroutineScope(Dispatchers.IO).launch {
            initMassiveArray()
        }
    }

    fun initMassiveArray(){
        val array = arrayOfNulls<Int>(1000000)
        array.forEach { println(it) }
    }
}