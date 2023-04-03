package com.example.casadeproductiefilme.data.remote

import com.example.casadeproductiefilme.data.local.entity.MovieEntity

data class MovieResponse(
    val id: Int,
    val name: String,
    val movieType: String,
    val category: String,
    val releaseYear: Int,
    val imageUrl: String
)

fun MovieResponse.toMovieEntity() = MovieEntity(
    movieID = id,
    name = name,
    movieType = movieType,
    category = category,
    releaseYear = releaseYear,
    imageUrl = imageUrl
)