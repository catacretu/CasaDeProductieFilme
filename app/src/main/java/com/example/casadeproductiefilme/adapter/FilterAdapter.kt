package com.example.casadeproductiefilme.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.casadeproductiefilme.R

class FilterAdapter(
    private val filterList: List<String>
) : RecyclerView.Adapter<FilterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.filter_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilterAdapter.ViewHolder, position: Int) {
        val item = filterList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return filterList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameFilter: Button = itemView.findViewById(R.id.button_filter)

        fun bind(item: String) {
            nameFilter.text = item
        }
    }
}