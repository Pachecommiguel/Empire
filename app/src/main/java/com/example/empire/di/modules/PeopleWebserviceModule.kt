package com.example.empire.di.modules

import com.example.empire.web.RetrofitApp
import com.example.empire.web.ws.PeopleWebservice
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PeopleWebserviceModule {

    @Singleton
    @Provides
    fun providePeopleWebservice(): PeopleWebservice = RetrofitApp
        .getInstance("https://swapi.py4e.com/api/")
        .create(PeopleWebservice::class.java)
}