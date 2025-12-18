package com.example.ecommerecapp.presentation.screens.home

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.ecommerecapp.presentation.screens.home.components.HomeContent

@Composable
fun HomeScreen(homeVm: HomeVm = hiltViewModel()) {
    val state by homeVm.state.collectAsState()
    val snackBarHostState = remember { SnackbarHostState() }
    LaunchedEffect(Unit) {
        homeVm.homeEffect.collect { effect ->
            when (effect) {
                is HomeEffect.NavigateToProductScreen -> {}
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
    HomeScreen()
}