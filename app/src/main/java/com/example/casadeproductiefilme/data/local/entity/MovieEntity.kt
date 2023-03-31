package com.example.casadeproductiefilme.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
class MovieEntity(
    @PrimaryKey(autoGenerate = false)
    val movieId: Int,
    val name: String,
    val movie_type: String,
    val category: String,
    val release_year: Int
)