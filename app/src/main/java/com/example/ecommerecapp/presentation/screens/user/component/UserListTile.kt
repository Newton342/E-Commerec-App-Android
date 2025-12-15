package com.example.ecommerecapp.presentation.screens.user.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerecapp.domain.model.User

@Composable
fun UserListTile(user: User) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = {})
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text("${user.name?.firstname} ${user.name?.lastname}", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                "${user.password}".replace(".".toRegex(), "*"),
                fontSize = 14.sp,
                color = Color.Gray.copy(0.7f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun UserListTilePreview() {
    UserListTile(
        user = User(
            address = null,
            email = null,
            id = null,
            name = null,
            password = null,
            phone = null,
            username = null,
            v = null
        )
    )
}