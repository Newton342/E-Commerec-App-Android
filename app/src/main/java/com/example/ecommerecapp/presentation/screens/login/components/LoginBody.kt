package com.example.ecommerecapp.presentation.screens.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecommerecapp.presentation.components.LongElevatedButton
import com.example.ecommerecapp.presentation.components.OutlinedPasswordTxtField
import com.example.ecommerecapp.presentation.components.OutlinedTxtField

@Composable
fun LoginBody(
    modifier: Modifier = Modifier,
    usernameTxtState: TextFieldState,
    passwordTxtState: TextFieldState,
    userTextHasError: Boolean = false,
    userErrorText: String? = null,
    passwordHasError: Boolean = false,
    passwordErrorText: String? = null,
    showPassword : Boolean = false,
    onTogglePassword: (Boolean) -> Unit,
    onSubmit: () -> Unit
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(16.dp), verticalArrangement = Arrangement.Center
    ) {

        OutlinedTxtField(
            state = usernameTxtState,
            prefixIcon = Icons.Outlined.PersonOutline,
            label = "User Name",
            hasError = userTextHasError,
            errorText = userErrorText
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedPasswordTxtField(
            state = passwordTxtState,
            onToggleShowPassword = onTogglePassword,
            hasError = passwordHasError,
            errorText = passwordErrorText,
            showPassword = showPassword
        )
        Spacer(modifier = Modifier.height(20.dp))
        LongElevatedButton(title = "Login", onClick = onSubmit)


    }
}

@Preview(showBackground = true)
@Composable
fun LoginBodyPreview() {

    LoginBody(
        usernameTxtState = TextFieldState(),
        passwordTxtState = TextFieldState(),
        onTogglePassword = {},
        onSubmit = {})
}