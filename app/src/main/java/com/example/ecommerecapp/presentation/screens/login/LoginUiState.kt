package com.example.ecommerecapp.presentation.screens.login

data class LoginUiState (
    val isLoading: Boolean = false,
    val isPasswordVisible: Boolean = false,

    val usernameError: String? = null,
    val passwordError: String? = null
)