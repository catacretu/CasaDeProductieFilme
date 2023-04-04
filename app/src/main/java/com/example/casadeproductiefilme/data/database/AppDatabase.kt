package com.example.casadeproductiefilme.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.casadeproductiefilme.data.local.dao.MovieDAO
import com.example.casadeproductiefilme.data.local.dao.UserDAO
import com.example.casadeproductiefilme.data.local.entity.MovieEntity
import com.example.casadeproductiefilme.data.local.entity.UserEntity

@Database(entities = [MovieEntity::class, UserEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getMovieDAO(): MovieDAO
    abstract fun getUserDAO(): UserDAO

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