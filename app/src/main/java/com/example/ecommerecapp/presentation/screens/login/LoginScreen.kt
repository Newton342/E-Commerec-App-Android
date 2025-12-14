package com.example.ecommerecapp.presentation.screens.login

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices.PIXEL_9
import androidx.compose.ui.tooling.preview.Preview
import com.example.ecommerecapp.presentation.screens.login.components.LoginBody


@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth().safeContentPadding(),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(
                onClick = {}) {
                Text("Get Users")
            }
        }

        LoginBody()
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    device = PIXEL_9,
    showBackground = true,
    name = "Login Screen Night mode"
)
@Composable
fun LoginScreenPreviewDark() {
    LoginScreen()
}

@Preview(showBackground = true, device = PIXEL_9, name = "Login Screen")
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}