package com.example.ecommerecapp.presentation.screens.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.ecommerecapp.domain.model.ProductModel
import com.example.ecommerecapp.domain.model.Rating

@Composable
fun ProductItem(modifier: Modifier = Modifier, product: ProductModel) {
    Box(
        modifier.border(
            shape = RoundedCornerShape(percent = 10),
            border = BorderStroke(1.dp, color = Color.Gray.copy(0.3f))
        )
    ) {
        Column(modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {

            AsyncImage(
                model = product.image,
                contentDescription = product.description,
                modifier = Modifier.height(150.dp)
            )
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    product.title ?: "",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Price ${product.price}")
                Text("${product.rating?.rate ?: 0}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    ProductItem(
        product = ProductModel(
            category = "Electronic",
            description = "SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s",
            id = 1,
            image = "https://fakestoreapi.com/img/61U7T1koQqL._AC_SX679_t.png",
            price = 109.00,
            rating = Rating(
                count = 2, rate = 2.9
            ),
            title = "SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s"
        )
    )
}