package com.example.taxcalculatorandroid.di

import com.example.taxcalculatorandroid.data.RegionDatabase
import com.example.taxcalculatorandroid.data.RegionDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideRegionDao(regionDatabase: RegionDatabase) : RegionDatabaseDao = regionDatabase.regionDao()
}