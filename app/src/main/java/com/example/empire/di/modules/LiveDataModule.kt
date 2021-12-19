package com.example.empire.di.modules

import androidx.lifecycle.MediatorLiveData
import com.example.empire.persistence.db.CharacterDao
import com.example.empire.persistence.entities.Character
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LiveDataModule {

    @Singleton
    @Provides
    fun provideLiveData(dao: CharacterDao): MediatorLiveData<List<Character>> =
        MediatorLiveData<List<Character>>().also { mediator ->
            mediator.addSource(dao.getAll()) {
                if (mediator.value.isNullOrEmpty()) mediator.value = it
            }
        }
}