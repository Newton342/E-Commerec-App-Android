package com.example.ecommerecapp.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices.PIXEL_9
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OutlinedPasswordTxtField(
    modifier: Modifier = Modifier,
    state: TextFieldState,
    showPassword: Boolean = false,
    hasError: Boolean = false,
    errorText: String? = null,
    onToggleShowPassword: (Boolean) -> Unit
) {
    Column(modifier = modifier.fillMaxWidth()) {
        BasicSecureTextField(
            state = state,
            textObfuscationMode = if (showPassword) TextObfuscationMode.Visible else TextObfuscationMode.Hidden,
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle.Default.copy(
                fontSize = 16.sp
            ),
            decorator = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            shape = RoundedCornerShape(10.dp),
                            width = 1.2.dp,
                            color = if (hasError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.outline
                        )
                        .padding(horizontal = 8.dp, vertical = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Lock,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.padding(horizontal = 10.dp)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Box(
                            modifier = Modifier.weight(1f)
                        ) {
                            if (state.text.isEmpty()) {
                                Text(
                                    text = "Password",
                                    color = Color.Gray.copy(alpha = 0.6f),
                                    fontSize = 16.sp
                                )
                            }
                            innerTextField()
                        }
                    }

                    Icon(
                        if (showPassword) {
                            Icons.Filled.Visibility
                        } else {
                            Icons.Filled.VisibilityOff
                        },
                        contentDescription = "Toggle password visibility",
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .clickable { onToggleShowPassword(!showPassword) })
                }
            })

        if (hasError && errorText != null) {
            Text(
                text = errorText,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(horizontal = 5.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.W300
            )
        }
    }

}


@Preview(showBackground = true, device = PIXEL_9)
@Composable
fun OutlinedPasswordTxtFieldPreview() {
    OutlinedPasswordTxtField(state = TextFieldState()) {}

}