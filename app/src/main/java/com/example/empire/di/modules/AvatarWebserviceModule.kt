package com.example.empire.di.modules

import com.example.empire.web.RetrofitApp
import com.example.empire.web.ws.AvatarWebservice
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AvatarWebserviceModule {

    @Singleton
    @Provides
    fun provideAvatarWebservice(): AvatarWebservice = RetrofitApp
        .getInstance("https://eu.ui-avatars.com/api/")
        .create(AvatarWebservice::class.java)
}