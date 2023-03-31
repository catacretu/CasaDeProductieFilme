package com.example.casadeproductiefilme.data.remote

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface MovieAPI {

    @GET("/catacretu/Project/master/MovieData")
    fun getMovies(): Single<List<MovieResponse>>
}