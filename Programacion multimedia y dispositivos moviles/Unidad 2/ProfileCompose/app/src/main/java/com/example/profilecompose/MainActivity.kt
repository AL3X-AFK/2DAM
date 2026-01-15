package com.example.profilecompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationWrapper()
//            Scaffold(
//                modifier = Modifer
//                    .background(R.color.purple_200),
//                topBar = { topBar() },
//                content = { app() }
//            )
        }
    }
}

@Preview
@Composable
fun topBar() {
    LazyRow {
        item {
            Text(
                text = "App Profile"
            )
        }
    }
}

@SuppressLint("ResourceAsColor")
@Preview(showBackground = true)
@Composable
fun content() {
    var counter_likes by rememberSaveable { mutableStateOf(0) }

    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 8.dp),

        ) {
        item {
            Image(
                painter = painterResource(R.drawable.user),
                contentDescription = "Profile",
                modifier = Modifier.fillMaxWidth()
            )

            Row {

                Text(
                    text = "Fernando Profile",
                    color = Color(R.color.white),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 18.dp)
                        .wrapContentSize(Alignment.Center)

                )

                Image(
                    painterResource(R.drawable.icon_heart),
                    contentDescription = "likes",
                    Modifier.clickable {
                        counter_likes++
                    }
                )
                Text(
                    text = counter_likes.toString(),

                    )

            }
        }
    }

}