package com.example.ecommerecapp.presentation.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecommerecapp.domain.model.ProductModel

@Composable
fun HomeBody(modifier: Modifier = Modifier, productList: List<ProductModel> = emptyList()) {
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 15.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        columns = GridCells.Fixed(2)
    ) {
        items(productList) { product ->
            ProductItem(product = product)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeBodyPreview() {
    HomeBody()
}