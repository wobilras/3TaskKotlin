package com.example.a3taskkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a3taskkotlin.databinding.ListItemBinding
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateAdapter(private val context: Context): RecyclerView.Adapter<DateAdapter.DateHolder>() {
    private val dateList: MutableList<String> = mutableListOf()
    class DateHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = ListItemBinding.bind(item)
        fun bind(dateString: String) = with(binding){
            textTimeOfPhoto.text = dateString
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return DateHolder(view)
    }

    override fun getItemCount(): Int {
        return dateList.size
    }

    override fun onBindViewHolder(holder: DateHolder, position: Int) {
        holder.bind(dateList[position])
    }
    fun loadData() {
        val file = File(context.getExternalFilesDir("photos"), "date.txt")
        if (file.exists()) {
            dateList.clear()
            val reader = BufferedReader(FileReader(file))
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                dateList.add(line!!)
            }
            reader.close()
            notifyDataSetChanged()
        }
    }

}