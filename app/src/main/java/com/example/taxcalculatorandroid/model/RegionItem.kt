package com.example.taxcalculatorandroid.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.*

@Entity(tableName = "regions_tbl")
data class RegionItem(
    @PrimaryKey
    val id : UUID = UUID.randomUUID(),

    @ColumnInfo(name = "region_name")
    val regionName : String,

    @ColumnInfo(name = "taxBand_1")
    val taxBand1 : Double,

    @ColumnInfo(name = "taxBand_2")
    val taxBand2 : Double,

    @ColumnInfo(name = "taxBand_3")
    val taxBand3 : Double,

    @ColumnInfo(name = "taxBand_4")
    val taxBand4 : Double,

    @ColumnInfo(name = "taxTier_1")
    val taxTier1 : Double,

    @ColumnInfo(name = "taxTier_2")
    val taxTier2 : Double,

    @ColumnInfo(name = "taxTier_3")
    val taxTier3 : Double,

    @ColumnInfo(name = "taxTier_4")
    val taxTier4 : Double,

    @ColumnInfo(name = "date_created")
    val entryDate : Date = Date.from(Instant.now()),

    @ColumnInfo(name = "date_updated")
    val updateDate: Date = Date.from(Instant.now())

)
