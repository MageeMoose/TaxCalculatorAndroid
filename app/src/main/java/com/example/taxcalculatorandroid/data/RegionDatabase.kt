package com.example.taxcalculatorandroid.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.taxcalculatorandroid.model.Region


@Database(entities = [Region::class], version = 1, exportSchema = false)
abstract class RegionDatabase : RoomDatabase() {
    abstract fun regionDao() : RegionDatabaseDao
}