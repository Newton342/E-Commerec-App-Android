package com.example.ecommerecapp.presentation.screens.product.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.ecommerecapp.domain.model.ProductModel
import com.example.ecommerecapp.presentation.components.CustomAppBar

@Composable
fun ProductContent(
    modifier: Modifier = Modifier, productData: ProductModel, onClickBack: () -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(), topBar = {
            CustomAppBar(title = productData.title ?: "", onBackPressed = onClickBack)
        }) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()

        ) {
            AsyncImage(
                productData.image,
                contentDescription = productData.description,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(productData.title ?: "", fontSize = 16.sp, fontWeight = FontWeight.W500)
            Spacer(modifier = Modifier.height(10.dp))
            Text(productData.description ?: "")
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Price ${productData.price}", fontSize = 16.sp, fontWeight = FontWeight.W500
                )
                Text(
                    "Rating ${productData.rating?.rate}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500
                )
            }
        }
    }
}