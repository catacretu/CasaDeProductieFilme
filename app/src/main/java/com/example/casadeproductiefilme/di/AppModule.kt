package com.example.casadeproductiefilme.di

import android.content.Context
import com.example.casadeproductiefilme.data.database.AppDatabase
import com.example.casadeproductiefilme.data.local.dao.MovieDAO
import com.example.casadeproductiefilme.data.remote.MovieAPI
import com.example.casadeproductiefilme.data.remote.RemoteDataSource
import com.example.casadeproductiefilme.data.repository.MovieRepository
import com.example.casadeproductiefilme.data.repository.MovieRepositoryImpl
import com.example.casadeproductiefilme.presenters.MoviePresenter
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideContext() = context

    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase {
        return AppDatabase.getAppDatabase(context)
    }

    @Singleton
    @Provides
    fun provideMovieDAO(appDatabase: AppDatabase): MovieDAO {
        return appDatabase.getMovieDAO()
    }

    @Singleton
    @Provides
    fun provideGson() = Gson()

    @Singleton
    @Provides
    fun provideMovieAPI(remoteDataSource: RemoteDataSource): MovieAPI {
        return remoteDataSource.buildApi(MovieAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideMovieRepository(movieAPI: MovieAPI, movieDAO: MovieDAO): MovieRepository {
        return MovieRepositoryImpl(movieAPI, movieDAO)
    }

    @Singleton
    @Provides
    fun provideMoviePresenter(movieRepository: MovieRepository): MoviePresenter {
        return MoviePresenter(movieRepository)
    }
}