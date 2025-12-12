package com.example.profilecompose

import android.R.attr.name
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun NavigationWrapper(){
    Log.i("ANTES", "Se crea la BBDD")
    val context = LocalContext.current
    val db = DBHelper(context, null)
    db.addUser()


    val navController = rememberNavController()

    NavHost(navController  = navController, startDestination=Login) {
        composable<Login> {
            LoginScreen{ navController.navigate(Searcher) }
        }
        composable<Searcher> {
            SearcherScreen {name -> navController.navigate(Profile(name=name)) }
        }

        composable<Profile> {backStackEntry ->
            val profile:Profile = backStackEntry.toRoute()
            ProfileScreen(profile.name){name ->
                navController.navigate(Detail(name = name))
            }
        }

        composable<Detail> { backStackEntry ->
            val detail: Detail = backStackEntry.toRoute()
            DetailScreen(detail.name){navController.navigateUp()}
        }
    }
}

