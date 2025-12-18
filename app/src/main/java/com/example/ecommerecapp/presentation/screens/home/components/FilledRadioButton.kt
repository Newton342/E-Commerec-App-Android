package com.example.ecommerecapp.presentation.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecommerecapp.common.applyIf

@Composable
fun FilledRadioButton(value: String, groupValue: String, onSelected: (String) -> Unit) {
    val isSelected = value == groupValue
    Box(modifier = Modifier
        .clickable(onClick = { onSelected(value) })
        .applyIf(isSelected) {
            background(
                color = MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(5.dp)
            )
        }
        .border(
            width = 0.5.dp,
            color = MaterialTheme.colorScheme.primary,
            shape = RoundedCornerShape(5.dp),
        )
        .padding(4.dp)) {
        Text("Click Me")
    }
}

@Preview(showBackground = true)
@Composable
fun FilledRadioButtonPreview() {
    FilledRadioButton(
        value = "awd", groupValue = "awa"
    ) {}
}