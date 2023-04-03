package com.example.casadeproductiefilme.di

import com.example.casadeproductiefilme.MovieApp
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivitiesModule::class,
        FragmentsModule::class
    ]
)

@Singleton
interface AppComponent {
    fun inject(app: MovieApp)
}