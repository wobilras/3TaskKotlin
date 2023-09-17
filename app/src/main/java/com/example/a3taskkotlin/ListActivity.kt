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
    }
    fun init(){
        binding.apply {
            rcListView.layoutManager = LinearLayoutManager(this@ListActivity)
            adapter = DateAdapter(readDatesFromFile())
            rcListView.adapter = adapter
        }
    }
    private fun readDatesFromFile(): List<Date> {
        val file = File(getExternalFilesDir(null), "photos/date")
        val dateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
        val dates = mutableListOf<Date>()

        if (file.exists()) {
            val lines = file.readText().trim().split("\n")
            for (line in lines) {
                val trimmedLine = line.trim()
                val date = dateFormat.parse(trimmedLine)
                date?.let { dates.add(date) }
            }
        }

        return dates.sorted()
    }
}