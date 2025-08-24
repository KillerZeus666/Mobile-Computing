package com.example.talleruno.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

//Composable son Funciones como piezas de rompecabezas

@Composable
fun MensajeBienvenida( nombre : String){
    Text(
        "Bienvenidos a ${nombre}",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue
        )
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun MensajeBienvenidaPreview(){
    MensajeBienvenida("Ig")
}

//Unidades de medida sp vs dp
//Usar texto de acuerdo a sp

@Composable
fun BodyHomeScreen(){
    Column {
        MensajeBienvenida("Twitter")
    }
}