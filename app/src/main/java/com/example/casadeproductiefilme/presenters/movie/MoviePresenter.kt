package com.example.casadeproductiefilme.presenters.movie

import com.example.casadeproductiefilme.data.local.entity.MovieEntity
import com.example.casadeproductiefilme.data.repository.MovieRepository
import javax.inject.Inject

class MoviePresenter @Inject constructor(
    private val movieRepository: MovieRepository
) : MovieInterface.Presenter {

    private var movieList: List<MovieEntity>? = null
    lateinit var mainView: MovieInterface.View

    init {
        loadMovieData()
    }

    private fun loadMovieData() {
        movieList = movieRepository.getMovies().blockingGet()
    }

    override fun getMovies(): List<MovieEntity> {
        return movieList!!
    }

    override fun inflateMovies() {
        mainView.initRecyclerViewMovies()
    }
}