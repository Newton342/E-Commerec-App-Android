package com.example.ecommerecapp.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(
    title: String, onBackPressed: (() -> Unit)? = null
) {
    CenterAlignedTopAppBar(title = { Text(title) }, navigationIcon = {
        if (onBackPressed != null) {
            IconButton(
                onClick = onBackPressed
            ) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Go to back screen"
                )
            }
        }
    }

    )
}


@Preview
@Composable
fun AppBarPreview() {
    CustomAppBar(title = "Users")
}


