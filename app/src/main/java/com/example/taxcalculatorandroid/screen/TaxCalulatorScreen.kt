package com.example.taxcalculatorandroid.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.taxcalculatorandroid.model.Region




@Composable
fun TaxCalculatorScreen(navController: NavController)
                        //region: List<Region>)
    { 
    



}
@Preview
@Composable
fun MainContent(){
    Column(Modifier.padding(12.dp)) {
        TaxCalculator()

    }
}

@Composable
fun TaxCalculator(){
    TopHeader()

    var salary by remember {mutableStateOf(0.0)}
    var selectedRegion by remember{ mutableStateOf("") }
    Surface(
        Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .fillMaxHeight()) {

        Column(Modifier
            .padding(6.dp),
            verticalArrangement =  Arrangement.Top,
            horizontalAlignment = Alignment.Start) {




        }
    }
}

@Preview
@Composable
fun TopHeader(netSalary: Double = 0.0){
    Surface(
        Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .height(155.dp)
            .clip(shape = CircleShape.copy(all = CornerSize(12.dp))),
        color = Color(0xFFDAD8DB)) {
        Column(Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally){
         val nSalary = "%.2f".format(netSalary)
         
         Text(text = "Your net Salary is", style = MaterialTheme.typography.h5)
         Text(text = "€$nSalary", style = MaterialTheme.typography.h4, fontWeight = FontWeight.Bold)
         Text(text = "Your tax is", style = MaterialTheme.typography.h6)
         Text(text = "25%", style = MaterialTheme.typography.h5)
            
        }
        
    }
}
