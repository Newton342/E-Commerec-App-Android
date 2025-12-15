package com.example.ecommerecapp.presentation.screens.login

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices.PIXEL_9
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ecommerecapp.presentation.navigation.Screen
import com.example.ecommerecapp.presentation.screens.login.components.LoginBody


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(modifier: Modifier = Modifier, navController: NavController) {
    Scaffold(
        modifier.fillMaxSize(), topBar = {
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
            LoginBody()
        }


    }

}

@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    device = PIXEL_9,
    showBackground = true,
    name = "Login Screen Night mode"
)
@Composable
fun LoginScreenPreviewDark() {
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}

@Preview(showBackground = true, device = PIXEL_9, name = "Login Screen")
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}