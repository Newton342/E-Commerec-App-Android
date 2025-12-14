package com.example.ecommerecapp.presentation.navigation

sealed class Screen(val route:String){
    object LoginScreen :  Screen("login")
    object UserListScreen :  Screen("user_list")
    object HomeScreen :  Screen("user_list")
}
