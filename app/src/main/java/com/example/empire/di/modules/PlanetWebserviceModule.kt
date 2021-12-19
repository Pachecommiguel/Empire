package com.example.empire.di.modules

import com.example.empire.web.RetrofitApp
import com.example.empire.web.ws.PlanetWebservice
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PlanetWebserviceModule {

    @Singleton
    @Provides
    fun providePlanetWebservice(): PlanetWebservice = RetrofitApp
        .getInstance("https://swapi.py4e.com/api/")
        .create(PlanetWebservice::class.java)
}