package com.example.ecommerecapp.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PopupMenuButton(
    isExpanded: Boolean = false,
    menuItems: List<String> = emptyList(),
    onClick: () -> Unit,
    onDismiss: () -> Unit,
    onItemSelected: (String) -> Unit
) {
    Box {
        IconButton(
            onClick = onClick
        ) {
            Icon(Icons.Default.MoreVert, contentDescription = "More Options")
        }
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = onDismiss,
        ) {
            menuItems.forEach { option ->
                DropdownMenuItem(text = { Text(option) }, onClick = { onItemSelected(option) })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PopupMenuButtonPreview() {
    PopupMenuButton(
        onClick = {},
        onDismiss = {},
    ) {}
}

