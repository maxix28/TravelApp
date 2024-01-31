package com.example.travelapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.travelapp.ui.Screens.LoginScreen
import com.example.travelapp.ui.Screens.MainScreen

@Composable
fun NavGraph(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = Destination.Login.route ){
        composable(route = Destination.Login.route){
            LoginScreen (onSuccessLogin = {navHostController.navigate(Destination.MainScreen.route)})

        }
        composable(route = Destination.MainScreen.route){
            MainScreen()

        }
        composable(route = Destination.MyTicket.route){
            MainScreen()

        }
        composable(route = Destination.Account.route){
            MainScreen()

        }
        composable(route = Destination.BusRoutes.route){
            MainScreen()

        }
        composable(route = Destination.OrderingTicket.route){
            MainScreen()

        }
        composable(route = Destination.PastTicket.route){
            MainScreen()

        }

    }

}