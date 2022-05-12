package com.example.taxcalculatorandroid.data

import androidx.room.*
import com.example.taxcalculatorandroid.model.Region
import kotlinx.coroutines.flow.Flow


@Dao
interface RegionDatabaseDao {

    @Query("SELECT * from regions_tbl")
    fun getRegions() : Flow<List<Region>>

    @Query("SELECT * from regions_tbl where id = :id")
    suspend fun getRegionById(id: String) : Region

    @Query("SELECT * from regions_tbl where region_name = :regionName")
    suspend fun  getRegionByRegionName(regionName: String) : Region

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(region : Region)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(region: Region)

    @Delete
    suspend fun deleteRegion(region: Region)

}