package com.example.taxcalculatorandroid.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taxcalculatorandroid.model.Region

@Preview
@Composable
fun TaxCalculatorScreen()
    //region: List<Region>)
    {

    var salary by remember {mutableStateOf(0.0)}
    var selectedRegion by remember{ mutableStateOf("") }
    Surface(
        Modifier
            .padding(12.dp)
            .fillMaxWidth()) {

        Column(Modifier
            .padding(6.dp),
            verticalArrangement =  Arrangement.Top,
            horizontalAlignment = Alignment.Start) {




        }
    }


}
