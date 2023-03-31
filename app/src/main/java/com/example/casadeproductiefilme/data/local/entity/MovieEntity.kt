package com.example.casadeproductiefilme.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
class MovieEntity(
    @PrimaryKey(autoGenerate = false)
    val movieID: Int,
    val name: String,
    val movieType: String,
    val category: String,
    val releaseYear: Int,
    val imageUrl: String
)