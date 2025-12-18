package com.example.ecommerecapp.presentation.screens.home

sealed interface HomeEffect {
    data class NavigateToProductScreen(val id: Int) : HomeEffect
    data class ShowSnackBar(val message: String): HomeEffect
}