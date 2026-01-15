package com.example.profilecompose

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.example.profilecompose.dataBase.DBHelper
import androidx.compose.runtime.LaunchedEffect


@Composable
fun NavigationWrapper(){
    Log.i("ANTES", "Se crea la BBDD")
    val context = LocalContext.current
    val db = DBHelper(context, null)
    db.addUser("admin", "password")


    val navController = rememberNavController()
    NavHost(navController, startDestination = "login") {

        composable("login") {
            LoginScreen { username, password ->
                navController.navigate("check_access/$username/$password")
            }
        }

        composable(
            "check_access/{username}/{password}",
            arguments = listOf(
                navArgument("username") { type = NavType.StringType },
                navArgument("password") { type = NavType.StringType }
            )
        ) { backEntry ->
            val username = backEntry.arguments?.getString("username")
            val password = backEntry.arguments?.getString("password")
            LaunchedEffect(Unit) {
                if (db.isThereAnyone(username, password)) {
                    navController.navigate("searcher") {
                        popUpTo("login") { inclusive = true }
                    }
                } else {
                    navController.navigateUp()
                }
            }
        }

        composable("searcher") {
            CheckAccess(username = null, password = null) { name ->
                navController.navigate("profile/$name")
            }
        }

        composable(
            "profile/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { backEntry ->
            val name = backEntry.arguments?.getString("name") ?: ""
            ProfileScreen(name) {
                navController.navigate("detail/$name")
            }
        }

        composable(
            "detail/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { backEntry ->
            val name = backEntry.arguments?.getString("name") ?: ""
            DetailScreen(name) {
                navController.navigateUp()
            }
        }
    }
}

