package com.example.taxcalculatorandroid.di

import android.content.Context
import androidx.room.Room
import com.example.taxcalculatorandroid.data.RegionDatabase
import com.example.taxcalculatorandroid.data.RegionDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideRegionDao(regionDatabase: RegionDatabase) : RegionDatabaseDao = regionDatabase.regionDao()

    @Singleton
    @Provides
    fun providesAppDatabase(@ApplicationContext context: Context) : RegionDatabase =
        Room.databaseBuilder(
            context,
            RegionDatabase::class.java,
            "region_db")
            .fallbackToDestructiveMigration().
            build()
}