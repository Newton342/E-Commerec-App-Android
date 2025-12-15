package com.example.ecommerecapp.presentation.components


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices.PIXEL_9
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OutlinedTxtField(
    text: String,
    hasError: Boolean = false,
    label: String = "Label",
    prefixIcon: ImageVector? = null,
    errorText: String? = null,
    onChange: (String) -> Unit
) {
    val errorColor: Color = Color(0xFFF44336)
    Column(modifier = Modifier.fillMaxWidth()) {
        BasicTextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = onChange,
            minLines = 1,
            textStyle = TextStyle.Default.copy(
                fontSize = 16.sp
            ),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier
                        .border(
                            shape = RoundedCornerShape(10.dp),
                            width = 1.2.dp,
                            color = if (hasError) errorColor else Color.Gray.copy(alpha = 0.5f)
                        )
                        .padding(horizontal = 8.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (prefixIcon != null) {
                        Icon(
                            prefixIcon,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.padding(horizontal = 10.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))

                    Box(
                        modifier = Modifier.weight(1f)
                    ) {
                        if (text.isEmpty()) {
                            Text(
                                label,
                                color = if (hasError) errorColor else Color.Gray.copy(alpha = 0.6f),
                                fontSize = 16.sp
                            )
                        }
                        innerTextField()
                    }

                }
            })
        if (hasError && errorText != null) {
            Text(
                text = errorText,
                color = errorColor,
                modifier = Modifier.padding(horizontal = 5.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.W300
            )
        }
    }


}


@Preview(showBackground = true, device = PIXEL_9)
@Composable
fun TextFieldPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTxtField(text = "") {}
    }

}