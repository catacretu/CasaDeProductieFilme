package com.example.casadeproductiefilme.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.casadeproductiefilme.data.local.entity.MovieEntity
import io.reactivex.rxjava3.core.Single

@Dao
interface MovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovies(movieList: List<MovieEntity>)

    @Query("Select * FROM movie_table")
    fun getAllMovies(): Single<List<MovieEntity>>
}