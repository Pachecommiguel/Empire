package com.example.empire.di.modules

import androidx.lifecycle.MutableLiveData
import com.example.empire.persistence.entities.Character
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MutableLiveDataModule {

    @Singleton
    @Provides
    fun provideMutableListLiveData(): MutableLiveData<List<Character>> =
        MutableLiveData<List<Character>>(listOf())

    @Singleton
    @Provides
    fun provideMutableArrayListLiveData(): MutableLiveData<ArrayList<Character>> =
        MutableLiveData<ArrayList<Character>>(arrayListOf())
}