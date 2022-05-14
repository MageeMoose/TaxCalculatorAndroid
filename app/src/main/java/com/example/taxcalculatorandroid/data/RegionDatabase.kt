package com.example.taxcalculatorandroid.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.taxcalculatorandroid.model.Region
import com.example.taxcalculatorandroid.utils.DateConverter
import com.example.taxcalculatorandroid.utils.UUIDConverter


@Database(entities = [Region::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class RegionDatabase : RoomDatabase() {
    abstract fun regionDao() : RegionDatabaseDao
}