package com.example.ecommerecapp.presentation.screens.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecommerecapp.presentation.components.OutlinedTxtField
import com.example.ecommerecapp.presentation.components.PopupMenuButton
import com.example.ecommerecapp.presentation.screens.home.HomeUiEvent
import com.example.ecommerecapp.presentation.screens.home.HomeUiState

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,snackBarHostState: SnackbarHostState, homeState: HomeUiState, onEvent: (HomeUiEvent) -> Unit
) {
    Scaffold(modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) }
        ) { paddingValues ->
        Column(
            modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTxtField(
                    modifier = Modifier.weight(1f), state = TextFieldState(), label = "Search"
                )
                PopupMenuButton(onClick = {
                    onEvent(HomeUiEvent.ToggleDropDown(true))
                }, onDismiss = {
                    onEvent(HomeUiEvent.ToggleDropDown(false))
                }, menuItems = listOf("asc", "desc")) {
                    onEvent(HomeUiEvent.SelectedDropdownValue(it))
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            HomeBody(
                productList = homeState.productList
            )
        }

    }
}

@Preview
@Composable
fun HomeContentPreview() {
    val snackBarHostState = remember { SnackbarHostState() }
    HomeContent(snackBarHostState = snackBarHostState, homeState = HomeUiState()) {}
}