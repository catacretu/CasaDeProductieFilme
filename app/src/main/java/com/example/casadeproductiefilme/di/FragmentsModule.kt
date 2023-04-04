package com.example.casadeproductiefilme.di

import com.example.casadeproductiefilme.views.AdminFragment
import com.example.casadeproductiefilme.views.HomeFragment
import com.example.casadeproductiefilme.views.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributeAdminFragment(): AdminFragment
}