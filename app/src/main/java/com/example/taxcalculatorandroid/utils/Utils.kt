package com.example.taxcalculatorandroid.utils

import com.example.taxcalculatorandroid.model.Region
import java.text.SimpleDateFormat
import java.util.*

fun formatDate(time: Long): String{
    val date = Date(time)
    val format =SimpleDateFormat("EEE, d MMM hh:mm aaa", Locale.getDefault())

    return format.format(date)
}

data class TaxTier(
    var band: Double,
    var tier: Double
)

data class Salary(
    var gross: Double,
    var taxRate: TaxTier,
    var taxAmount: Double = gross * taxRate.tier,
    var net: Double = gross - taxAmount
)

fun getTax(region: Region, grossSalary: Double): Salary {


    val taxTiers = arrayOf(
        TaxTier(band = region.taxBand1, tier = region.taxTier1),
        TaxTier(band = region.taxBand2, tier = region.taxTier2),
        TaxTier(band = region.taxBand3, tier = region.taxTier3),
        TaxTier(band = region.taxBand4, tier = region.taxTier4),
    )

    return calculateSalary(grossSalary, taxTiers)
}

fun findTaxTier(grossSalary: Double, taxRate: Array<TaxTier> ): TaxTier{
    for (tier in taxRate.sortedByDescending { T-> T.band }){
        if(grossSalary >= tier.band){
            return tier
        }
    }
    return TaxTier(band = grossSalary, tier = 0.0)
}

fun calculateSalary(salary: Double, taxRates: Array<TaxTier>) : Salary{
    val taxTier = findTaxTier(salary, taxRates)

    return Salary(gross = salary, taxRate = taxTier)
}


