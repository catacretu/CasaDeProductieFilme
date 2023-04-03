package com.example.casadeproductiefilme.data.remote

import com.example.casadeproductiefilme.data.local.entity.MovieEntity

data class MovieResponse(
    val id: Int,
    val name: String,
    val movie_type: String,
    val category: String,
    val release_year: Int,
    val imageUrl: String
)

fun MovieResponse.toMovieEntity() = MovieEntity(
    movieID = id,
    name = name,
    movieType = movie_type,
    category = category,
    releaseYear = release_year,
    imageUrl = imageUrl
)