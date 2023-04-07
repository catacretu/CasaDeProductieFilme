package com.example.casadeproductiefilme.presenters.movie

import com.example.casadeproductiefilme.data.local.entity.MovieEntity

interface MovieInterface {

    interface View {
        fun initRecyclerViewFilters()
        fun initRecyclerViewMovies()
    }

    interface Presenter {
        fun getMovies(): List<MovieEntity>
        fun inflateMovies()
    }
}