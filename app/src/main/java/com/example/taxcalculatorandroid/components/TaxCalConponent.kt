package com.example.taxcalculatorandroid.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp

import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.Alignment
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon as TrailingIcon


@ExperimentalComposeUiApi
@Composable
fun InputText(
    modifier : Modifier = Modifier,
    text : String,
    label : String,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit ={}){

    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(value = text,
        onValueChange =onTextChange,
        colors = TextFieldDefaults.textFieldColors(
        backgroundColor = Color.Transparent
        ),
        maxLines = maxLine,
        label = {Text(text = label)},
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        }),
        modifier = modifier
    )

}

@Composable
fun TexCalButton(
    modifier: Modifier = Modifier,
    text : String,
    onClick : () -> Unit,
    enabled : Boolean = true ){
    Button(onClick = onClick,
        shape = CircleShape,
        enabled = enabled,
        modifier = modifier){
        Text(text)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun RegionDropDown(){
    var expanded by remember{mutableStateOf(false)}
    val testList = listOf("Gävle", "Sundsvall", "Malmö")
    var selectedRegionText by remember { mutableStateOf("")}
    var dropDownWidth by remember { mutableStateOf(0)}
    val icon = if(expanded)
        Icons.Filled.ArrowDropUp
    else
        Icons.Filled.ArrowDropDown

    Column() {
              OutlinedTextField(
                value = selectedRegionText,
                onValueChange = { selectedRegionText = it },
                  modifier = Modifier
                      .fillMaxWidth()
                      .onSizeChanged {
                          dropDownWidth = it.width
                      },
                label = {Text(text = "Region")},
                trailingIcon = {Icon(icon, "contentDescription",
                    Modifier.clickable { expanded = !expanded }
                )}
              )

          DropdownMenu(expanded = expanded, onDismissRequest = {expanded = false },
              modifier = Modifier.width(with(LocalDensity.current){dropDownWidth.toDp()})) {
                testList.forEach { selectedRegion ->
                    DropdownMenuItem(
                        onClick = {
                            selectedRegionText = selectedRegion
                            expanded = false}) {
                        Text(text = selectedRegion)}
                }
            }
        }
}