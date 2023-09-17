package com.example.a3taskkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a3taskkotlin.databinding.FragmentListBinding
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class FragmentList : Fragment() {
    lateinit var binding: FragmentListBinding
    private lateinit var adapter: DateAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    fun init(){
        binding.apply {
            rcListView.layoutManager = LinearLayoutManager(activity)
            adapter = DateAdapter(readDatesFromFile())
            rcListView.adapter = adapter
        }
    }
    private fun readDatesFromFile(): List<Date> {
        val file = File(requireContext().getExternalFilesDir(null), "photos/date")
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