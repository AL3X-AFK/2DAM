package com.example.compose

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(
                topBar = { topBar() },
                content = { app() }
            )
        }


    }
}

@Composable
fun topBar() {
    LazyRow {
        item {
            Text("Aplicacion")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun app() {
    var name by remember { mutableStateOf("") }
    var txtname by remember { mutableStateOf("") }
    var counter_likes by rememberSaveable { mutableStateOf(0) }

    val context = LocalContext.current


    LazyColumn(Modifier.padding(horizontal = 8.dp)) {
        item {

            Image(
                painterResource(R.drawable.ds3),
                contentDescription = "Imagen",
                Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = txtname,
                onValueChange = { txtname = it },
                label = { "Nombre" },
                singleLine = true
            )

            Button(onClick = {
                name = txtname
            }) { Text("Pulsar") }

            Text(
                "Hola mundo",
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(12.dp)
                    .layoutId("nameText")
                    .wrapContentSize(Alignment.Center)

            )
            Text(
                name,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(12.dp)
                    .layoutId("nameText")
            )

            LazyRow {
                item {
                    Image(
                        painterResource(R.drawable.icon_heart),
                        contentDescription = "Icono de corazon",
                        Modifier.clickable(
                            true, onClick =
                                { counter_likes++ }
                        )
                    )

                    Text(
                        "$counter_likes Likes"
                    )
                }
            }



            LazyRow {
                item {
                    Text("Actividad de calculadora")
                    Button(
                        onClick = {
                            context.startActivity(Intent(context, Calculadora::class.java))
                        }
                    ) {
                        Text("Calculadora")
                    }
                }
            }

        }
    }

}
