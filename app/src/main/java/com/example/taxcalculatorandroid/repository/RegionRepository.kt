package com.example.taxcalculatorandroid.repository

import com.example.taxcalculatorandroid.data.RegionDatabaseDao
import com.example.taxcalculatorandroid.model.Region
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RegionRepository @Inject constructor(private val regionDatabaseDao: RegionDatabaseDao) {
    suspend fun addRegion(region: Region) = regionDatabaseDao.insert(region)
    suspend fun updateRegion(region: Region) = regionDatabaseDao.update(region)
    suspend fun deleteRegion(region: Region) = regionDatabaseDao.deleteRegion(region)
    fun getAllRegions():Flow<List<Region>> = regionDatabaseDao.getRegions().flowOn(Dispatchers.IO).conflate()

}