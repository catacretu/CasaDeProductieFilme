package com.example.casadeproductiefilme.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.casadeproductiefilme.R
import com.example.casadeproductiefilme.data.local.entity.MovieEntity

class MovieAdapter(
    private val movieList: List<MovieEntity>,
    private val context: Context
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = movieList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.name)
        private val movieType: TextView = itemView.findViewById(R.id.movieType)
        private val category: TextView = itemView.findViewById(R.id.category)
        private val releaseYear: TextView = itemView.findViewById(R.id.releaseYear)
        private val imageMovie: ImageView = itemView.findViewById(R.id.imageMovie)

        fun bind(item: MovieEntity) {
            name.text = item.name
            movieType.text = item.movieType
            category.text = item.category
            releaseYear.text = item.releaseYear.toString()
            Glide.with(context).load(item.imageUrl).into(imageMovie)
        }
    }
}