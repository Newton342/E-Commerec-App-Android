package com.example.ecommerecapp.presentation.screens.home

import android.util.Log
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ecommerecapp.presentation.navigation.Screen
import com.example.ecommerecapp.presentation.screens.home.components.HomeContent

@Composable
fun HomeScreen(homeVm: HomeVm = hiltViewModel(), navController: NavController) {
    val state by homeVm.state.collectAsState()
    val snackBarHostState = remember { SnackbarHostState() }
    LaunchedEffect(Unit) {
        homeVm.homeEffect.collect { effect ->
            when (effect) {
                is HomeEffect.NavigateToProductScreen -> {
                    Log.i("Args", "------${effect.id}")
                    navController.navigate(Screen.ProductScreen.route + "/${effect.id}")
                }

                is HomeEffect.ShowSnackBar -> {
                    snackBarHostState.showSnackbar(effect.message)
                }
            }
        }
    }

    HomeContent(snackBarHostState = snackBarHostState, homeState = state, onEvent = homeVm::onEvent)
}

@Preview
@Composable
private fun HomePreview() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}