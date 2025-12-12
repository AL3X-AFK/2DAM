package com.example.profilecompose

import android.R.attr.name
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

@Composable
fun NavigationWrapper(){
    Log.i("ANTES", "Se crea la BBDD")
    val context = LocalContext.current
    val db = DBHelper(context, null)
    db.addUser("admin", "password")


    val navController = rememberNavController()
    NavHost(navController  = navController, startDestination=NavRoutes.LOGIN) {
        composable(NavRoutes.LOGIN) {
            LoginScreen(
                navigateToCheckAccess = { username, password ->
                    navController.navigate("check_access/$username/$password")
                }
            )
        }

        composable(
            route = NavRoutes.CHECK_ACCESS_WITH_ARGS,
            arguments = ListOf(
                navArgument("username"){type = NavType.StringType},
                navArgument("password"){type = NavType.StringType}
            )
        ){ backEntry ->
            LaunchedEffect (key1 = Unit){
                val existe = db.isThereAnyone(username, password)
                if(existe){
                    navController.navigate(NavRoutes.SEARCHER){
                        popUpTo(NavRoutes.LOGIN){ inclusice = false }
                    }
                } else {
                    navController.navigateUp()
                }
            }
        }

        composable(NavRoutes.SEARCHER){
            SearcherScreen { name -> navController.navigate(Profile(name = name)) }
        }


        composable<Profile> {backStackEntry ->
            val profile:Profile = backStackEntry.toRoute()
            ProfileScreen(profile.name){navController.navigate(Detail(name = profile.name))
            }
        }

        composable<Detail> { backStackEntry ->
            val detail: Detail = backStackEntry.toRoute()
            DetailScreen(detail.name){navController.navigateUp()}
        }
    }
}

