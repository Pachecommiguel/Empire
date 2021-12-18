package com.example.empire.di.modules

import com.example.empire.web.RetrofitApp
import com.example.empire.web.ws.SpeciesWebservice
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SpeciesWebserviceModule {

    @Singleton
    @Provides
    fun provideSpeciesWebservice(): SpeciesWebservice = RetrofitApp.getInstance()
        .create(SpeciesWebservice::class.java)
}