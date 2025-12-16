package com.example.ecommerecapp.presentation.screens.user

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices.PIXEL_9
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ecommerecapp.network.NetworkUIState
import com.example.ecommerecapp.presentation.components.CircularProgressBar
import com.example.ecommerecapp.presentation.components.CustomAppBar
import com.example.ecommerecapp.presentation.screens.user.component.UserListTile

@Composable
fun GetUserScreen(
    modifier: Modifier = Modifier,
    userVm: UsersVm = hiltViewModel(),
    navController: NavController
) {

    val state = userVm.userData.collectAsStateWithLifecycle().value
    Scaffold(
        modifier.fillMaxSize(), topBar = {
            CustomAppBar(title = "Users") {
                navController.popBackStack()
            }
        }) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {

            when (state) {
                is NetworkUIState.Error -> {
                    Text(state.error, modifier = Modifier.fillMaxWidth())
                }

                is NetworkUIState.Loading -> {
                    CircularProgressBar()
                }

                is NetworkUIState.Success -> {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(items = state.data) { user ->
                            UserListTile(user)
                        }
                    }
                }
            }
        }


    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true, device = PIXEL_9)
@Composable
fun GetUserScreenPreview() {
    val navController = rememberNavController()
    GetUserScreen(navController = navController)
}