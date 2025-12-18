package com.example.ecommerecapp.presentation.screens.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.setTextAndPlaceCursorAtEnd
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices.PIXEL_9
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ecommerecapp.presentation.components.CircularProgressBar
import com.example.ecommerecapp.presentation.navigation.Screen
import com.example.ecommerecapp.presentation.screens.login.components.LoginBody


@SuppressLint("RememberReturnType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier, loginVm: LoginVm = hiltViewModel(), navController: NavController
) {

    val userName by navController.currentBackStackEntry?.savedStateHandle?.getStateFlow(
        "username", ""
    )?.collectAsState() ?: remember { mutableStateOf("") }

    val password by navController.currentBackStackEntry?.savedStateHandle?.getStateFlow(
        "password", ""
    )?.collectAsState() ?: remember { mutableStateOf("") }

    val usernameState = rememberTextFieldState()
    val passwordState = rememberTextFieldState()
    val state by loginVm.uiState.collectAsStateWithLifecycle()
    val snackBarHostState = remember { SnackbarHostState() }

    LaunchedEffect(userName) {
        usernameState.setTextAndPlaceCursorAtEnd(userName)
    }
    LaunchedEffect(password) {
        passwordState.setTextAndPlaceCursorAtEnd(password)
    }

    LaunchedEffect(Unit) {
        loginVm.uiEvent.collect { uiEvent ->
            when (uiEvent) {
                LoginUiEvent.NavigateToHomeScreen -> {
                    navController.navigate(Screen.HomeScreen.route) {
                        popUpTo(Screen.LoginScreen.route) {
                            inclusive = true
                        }
                    }
                }

                is LoginUiEvent.ShowSnackBar -> {
                    snackBarHostState.showSnackbar(uiEvent.message)
                }
            }
        }
    }
    Scaffold(
        modifier.fillMaxSize(),

        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        }, topBar = {
            TopAppBar(title = {}, actions = {
                TextButton(
                    onClick = {
                        navController.navigate(Screen.UserListScreen.route)
                    }) {
                    Text("Get Users")
                }
            })
        }) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .consumeWindowInsets(paddingValues)
                .imePadding()
        ) {
            if (state.isLoading) {
                CircularProgressBar()
            } else {
                LoginBody(
                    usernameTxtState = usernameState,
                    passwordTxtState = passwordState,
                    onTogglePassword = { isVisible ->
                        loginVm.togglePasswordVisibility(isVisible)
                    },
                    onSubmit = {
                        loginVm.onLogin(
                            username = usernameState.text.toString(),
                            password = passwordState.text.toString()
                        )
                    },
                    userTextHasError = state.usernameError != null,
                    userErrorText = state.usernameError,
                    passwordHasError = state.passwordError != null,
                    passwordErrorText = state.passwordError,
                    showPassword = state.isPasswordVisible
                )
            }

        }
    }

}


@Preview(showBackground = true, device = PIXEL_9, name = "Login Screen")
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}