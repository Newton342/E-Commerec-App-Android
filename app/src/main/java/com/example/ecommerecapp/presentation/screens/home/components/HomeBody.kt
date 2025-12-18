package com.example.ecommerecapp.presentation.screens.home.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeBody(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(), columns = GridCells.Fixed(2)
    ) {
        items(count = 10){
            ProductItem(modifier = Modifier.padding(5.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeBodyPreview() {
    HomeBody()
}