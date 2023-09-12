package com.example.a3taskkotlin

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class DateAdapter(private val dateList: List<DateItem>): RecyclerView.Adapter<DateAdapter.DateHolder>() {

    class DateHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = DateitemBinding
        fun bind(friend: DateItem) = with(binding){
            title.text = friend.title
        }
    }
}