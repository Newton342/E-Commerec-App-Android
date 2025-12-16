package com.example.ecommerecapp.presentation.screens.login

sealed class LoginUiEvent {
    object NavigateToHomeScreen: LoginUiEvent()
    data class ShowSnackBar(val message: String) :LoginUiEvent()
}