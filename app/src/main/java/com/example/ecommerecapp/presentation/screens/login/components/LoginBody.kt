package com.example.ecommerecapp.presentation.screens.login.components

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecommerecapp.presentation.components.OutlinedTxtField

@Composable
fun LoginBody(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .padding(16.dp), verticalArrangement = Arrangement.Center
    ) {

        OutlinedTxtField(
            text = "", prefixIcon = Icons.Outlined.PersonOutline, label = "User Name"
        ) {}
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTxtField(
            text = "", prefixIcon = Icons.Outlined.PersonOutline, label = "Password"
        ) {}
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun LoginBodyPreview() {
    LoginBody()
}