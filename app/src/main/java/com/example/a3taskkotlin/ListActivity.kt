package com.example.a3taskkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a3taskkotlin.databinding.ListActivityBinding
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ListActivity : AppCompatActivity() {
    lateinit var binding: ListActivityBinding
    private lateinit var adapter: DateAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    fun init(){
        binding.apply {
            rcListView.layoutManager = LinearLayoutManager(this@ListActivity)
            adapter = DateAdapter(this@ListActivity)
            rcListView.adapter = adapter
            adapter.loadData()
        }
    }
}