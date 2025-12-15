package com.example.ecommerecapp.presentation.screens.login.components

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecommerecapp.presentation.components.LongElevatedButton
import com.example.ecommerecapp.presentation.components.OutlinedPasswordTxtField
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
        OutlinedPasswordTxtField(state = TextFieldState()) { }
        Spacer(modifier = Modifier.height(20.dp))
        LongElevatedButton(title = "Login") { }


    }
}

@Preview(showBackground = true)
@Composable
fun LoginBodyPreview() {
    LoginBody()
}