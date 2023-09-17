package com.example.a3taskkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a3taskkotlin.databinding.ListItemBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateAdapter(private val dateList: List<Date>): RecyclerView.Adapter<DateAdapter.DateHolder>() {
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
        val date = dateList[position]
        val dateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
        val dateString = dateFormat.format(date)
        holder.bind(dateString)
    }

}