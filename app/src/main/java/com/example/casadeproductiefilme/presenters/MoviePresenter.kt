package com.example.casadeproductiefilme.presenters

import com.example.casadeproductiefilme.data.local.entity.MovieEntity
import com.example.casadeproductiefilme.data.repository.MovieRepository
import javax.inject.Inject

class MoviePresenter @Inject constructor(
    private val repository: MovieRepository
) : MovieInterface.Presenter {

    private var movieList: List<MovieEntity>? = null
    lateinit var mainView: MovieInterface.View

    init {
        loadMovieData()
    }

    override fun loadMovieData() {
        movieList = repository.getMovies().blockingGet()
    }

    override fun getMovies(): List<MovieEntity> {
        return movieList!!
    }

    override fun inflateMovies() {
        mainView.initRecyclerView()
    }
}