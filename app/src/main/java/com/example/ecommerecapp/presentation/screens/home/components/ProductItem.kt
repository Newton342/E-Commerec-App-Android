package com.example.ecommerecapp.presentation.screens.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun ProductItem(modifier: Modifier = Modifier) {
    Box(
        modifier.border(
                shape = RoundedCornerShape(percent = 10),
                border = BorderStroke(1.dp, color = Color.Gray.copy(0.3f))
            )
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            AsyncImage(
                "https://fakestoreapi.com/img/61U7T1koQqL._AC_SX679_t.png",
                contentDescription = "SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s"
            )
            Row(modifier = Modifier.fillMaxWidth()) {
                Text("SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s")
            }

            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Price 109.00")
                Text("2.9")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    ProductItem()
}