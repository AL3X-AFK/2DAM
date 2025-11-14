package com.example.compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            app()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun app() {
    var name by remember { mutableStateOf("") }
    var txtname by remember { mutableStateOf("") }
    val context = LocalContext.current

    LazyColumn(Modifier.fillMaxSize()) {
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

            Text("Hola mundo", fontSize = 20.sp, modifier = Modifier.padding(12.dp))
            Text("Hola mundo", fontSize = 20.sp, modifier = Modifier.padding(12.dp))
            Text("Hola mundo", fontSize = 20.sp, modifier = Modifier.padding(12.dp))
            Text("Hola mundo", fontSize = 20.sp, modifier = Modifier.padding(12.dp))
            Text("Hola mundo", fontSize = 20.sp, modifier = Modifier.padding(12.dp))
            Text("Hola mundo", fontSize = 20.sp, modifier = Modifier.padding(12.dp))
            Text("Hola mundo", fontSize = 20.sp, modifier = Modifier.padding(12.dp))
            Text("Hola mundo", fontSize = 20.sp, modifier = Modifier.padding(12.dp))
            Text("Hola mundo", fontSize = 20.sp, modifier = Modifier.padding(12.dp))
            Text("Hola mundo", fontSize = 20.sp, modifier = Modifier.padding(12.dp))
            Text(
                "Hola mundo",
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(12.dp)
                    .layoutId("nameText")
            )
            Text(
                name,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(12.dp)
                    .layoutId("nameText")
            )



            Button(onClick = {
                name = txtname
            }) { Text("Pulsar") }


        }

        item {
            LazyRow {
                item {
                    Text("blalblablallablbalbalbalbalblalbalbalbalbalb")
                }
            }
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
