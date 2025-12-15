package com.example.ecommerecapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecommerecapp.presentation.screens.login.LoginScreen
import com.example.ecommerecapp.presentation.screens.user.GetUserScreen

@Composable
fun AppNavController() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = Screen.LoginScreen.route
    ) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen()
        }

        composable(route = Screen.UserListScreen.route) {
            GetUserScreen()
        }
    }
}