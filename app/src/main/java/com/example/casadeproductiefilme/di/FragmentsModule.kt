package com.example.casadeproductiefilme.di

import com.example.casadeproductiefilme.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment
}