package com.example.taxcalculatorandroid.navigation

enum class NavScreens {
    TaxCalculatorScreen,
    RegionListScreen,
    EditRegionScreen;
    companion object{
        fun fromRoute(route : String?): NavScreens
        = when (route?.substringBefore("/")){
            TaxCalculatorScreen.name -> TaxCalculatorScreen
            EditRegionScreen.name -> EditRegionScreen
            RegionListScreen.name -> RegionListScreen
            null -> TaxCalculatorScreen
            else -> throw IllegalArgumentException("Route $route is not available")
        }
    }

}