package com.example.empire.di.modules

import com.example.empire.web.RetrofitApp
import com.example.empire.web.ws.VehicleWebservice
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object VehicleWebserviceModule {

    @Singleton
    @Provides
    fun provideVehicleWebservice(): VehicleWebservice = RetrofitApp
        .getInstance("https://swapi.py4e.com/api/")
        .create(VehicleWebservice::class.java)
}