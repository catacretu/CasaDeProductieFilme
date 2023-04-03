package com.example.casadeproductiefilme.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.casadeproductiefilme.data.local.entity.MovieEntity
import com.example.casadeproductiefilme.data.repository.MovieRepository
import javax.inject.Inject

class MovieViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {

    private var movieList: MutableLiveData<List<MovieEntity>> = MutableLiveData()

    init {
        loadMovieData()
    }

    fun getMovieObserver(): MutableLiveData<List<MovieEntity>> {
        return movieList
    }

    private fun loadMovieData() {
        val list = repository.getMovies().blockingGet()
        movieList.postValue(list)
    }
}