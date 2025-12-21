package com.example.ecommerecapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ecommerecapp.presentation.screens.home.HomeScreen
import com.example.ecommerecapp.presentation.screens.login.LoginScreen
import com.example.ecommerecapp.presentation.screens.product.ProductScreen
import com.example.ecommerecapp.presentation.screens.user.GetUserScreen

@Composable
fun AppNavController() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = Screen.LoginScreen.route
    ) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }

        composable(route = Screen.UserListScreen.route) {
            GetUserScreen(navController = navController)
        }

        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.ProductScreen.route + "/{id}", arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.IntType
                    nullable = false

                }
            )) {
            ProductScreen(navController = navController)
        }
    }
}