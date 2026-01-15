package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.ComposeTheme

class Calculadora : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            calc()

        }
    }
}

@Preview(showBackground = true)
@Composable
fun calc() {

    var numRadio by remember { mutableStateOf("") }
    var perimetro by remember { mutableStateOf("0.0") }


    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item{
            Text("Calculadora", fontSize=32.sp, modifier = Modifier.padding(40.dp))
            Text("Ingresa el Radio: ", fontSize = 16.sp)

            OutlinedTextField(
                value = numRadio,
                onValueChange = { numRadio = it },
                label = { Text("Radio") },
                singleLine = true
            )
            Text("El perimetro es: ", fontSize = 16.sp)
            Text(perimetro, fontSize = 32.sp)

            Button(onClick = {
                val num = 2*3.14*numRadio.toInt()
                perimetro = num.toString()
            }) {Text("Calcular") }
        }
    }
}