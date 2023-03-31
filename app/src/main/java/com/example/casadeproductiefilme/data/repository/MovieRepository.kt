package com.example.casadeproductiefilme.data.repository

import com.example.casadeproductiefilme.data.local.entity.MovieEntity
import io.reactivex.rxjava3.core.Single

interface MovieRepository {
    fun getMovies(): Single<List<MovieEntity>>
}