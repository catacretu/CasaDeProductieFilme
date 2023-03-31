package com.example.casadeproductiefilme.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.casadeproductiefilme.data.local.dao.MovieDAO
import com.example.casadeproductiefilme.data.local.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getMovieDAO(): MovieDAO

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext, AppDatabase::class.java, "Database"
                ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
            }
            return INSTANCE!!
        }
    }
}