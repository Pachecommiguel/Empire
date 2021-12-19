package com.example.empire.di.modules

import com.example.empire.persistence.db.CharacterDao
import com.example.empire.persistence.db.RoomApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CharacterDaoModule {

    @Singleton
    @Provides
    fun provideCharacterDao(roomApp: RoomApp): CharacterDao = roomApp.CharacterDao()
}