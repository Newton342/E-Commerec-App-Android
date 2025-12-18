package com.example.ecommerecapp.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecommerecapp.presentation.components.OutlinedTxtField
import com.example.ecommerecapp.presentation.components.PopupMenuButton

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier.fillMaxSize()) { paddingValues ->
        Column(
            modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTxtField(modifier = Modifier.weight(1f), state = TextFieldState(), label = "Search")
                PopupMenuButton(onClick = {}, onDismiss = {}) { }
            }

        }

    }
}

@Preview
@Composable
private fun HomePreview() {
    HomeScreen()
}