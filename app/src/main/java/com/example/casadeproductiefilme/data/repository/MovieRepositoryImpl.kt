package com.example.casadeproductiefilme.data.repository

import android.util.Log
import com.example.casadeproductiefilme.data.local.dao.MovieDAO
import com.example.casadeproductiefilme.data.local.entity.MovieEntity
import com.example.casadeproductiefilme.data.remote.MovieAPI
import com.example.casadeproductiefilme.data.remote.toMovieEntity
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieAPI: MovieAPI,
    private val movieDAO: MovieDAO
) : MovieRepository {

    override fun getMovies(): Single<List<MovieEntity>> {
        return movieAPI.getMovies().subscribeOn(Schedulers.io())
            .map { moviesResponseList ->
                moviesResponseList.map { movieResponseItem -> movieResponseItem.toMovieEntity() }
            }
            .observeOn(Schedulers.io())
            .doOnSuccess { movieDAO.saveMovies(it) }
            .onErrorResumeNext {
                Log.e("ErrorRetrofit", it.message!!)
                movieDAO.getAllMovies()
            }
    }
}