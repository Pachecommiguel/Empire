package com.example.empire.di.modules

import com.example.empire.web.RetrofitApp
import com.example.empire.web.ws.VehiclesWebservice
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object VehiclesWebserviceModule {

    @Singleton
    @Provides
    fun provideVehiclesWebservice(): VehiclesWebservice = RetrofitApp.getInstance()
        .create(VehiclesWebservice::class.java)
}