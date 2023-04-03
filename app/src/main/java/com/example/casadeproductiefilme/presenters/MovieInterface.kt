package com.example.casadeproductiefilme.presenters

import com.example.casadeproductiefilme.data.local.entity.MovieEntity

interface MovieInterface {

    interface View {
        fun initRecyclerView()
    }

    interface Presenter {
        fun loadMovieData()
        fun getMovies(): List<MovieEntity>
        fun inflateMovies()
    }
}