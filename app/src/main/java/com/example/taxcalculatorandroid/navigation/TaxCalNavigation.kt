package com.example.taxcalculatorandroid.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taxcalculatorandroid.screen.TaxCalculatorScreen

@Composable
fun TaxCalNavigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavScreens.TaxCalculatorScreen.name){
        composable(NavScreens.TaxCalculatorScreen.name){
            TaxCalculatorScreen(navController = navController)
        }
    }
}