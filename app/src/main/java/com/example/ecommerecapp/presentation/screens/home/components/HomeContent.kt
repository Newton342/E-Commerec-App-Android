package com.example.ecommerecapp.presentation.screens.home.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices.PIXEL_4
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecommerecapp.presentation.components.CircularProgressBar
import com.example.ecommerecapp.presentation.components.OutlinedTxtField
import com.example.ecommerecapp.presentation.components.PopupMenuButton
import com.example.ecommerecapp.presentation.screens.home.HomeUiEvent
import com.example.ecommerecapp.presentation.screens.home.HomeUiState
import com.example.ecommerecapp.presentation.ui.theme.ECommerecAppTheme
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged

@OptIn(FlowPreview::class)
@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    snackBarHostState: SnackbarHostState,
    homeState: HomeUiState,
    onEvent: (HomeUiEvent) -> Unit
) {
    val scrollState = rememberScrollState()
    val searchText = rememberTextFieldState()

    LaunchedEffect(searchText) {
        snapshotFlow { searchText.text }.debounce(300).distinctUntilChanged().collect { query->
            onEvent(HomeUiEvent.SearchProductByName(query.toString()))
        }
    }

    Scaffold(
        modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) }) { paddingValues ->
        Column(
            modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTxtField(
                    modifier = Modifier.weight(1f), state = searchText, label = "Search"
                )
                PopupMenuButton(isExpanded = homeState.isDropdownOpened, onClick = {
                    onEvent(HomeUiEvent.ToggleDropDown(true))
                }, onDismiss = {
                    onEvent(HomeUiEvent.ToggleDropDown(false))
                }, menuItems = listOf("asc", "desc")) {
                    onEvent(HomeUiEvent.SelectedDropdownValue(it))
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(scrollState),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                homeState.categoryList.forEach {
                    FilledRadioButton(
                        value = it, groupValue = homeState.selectedTabValue
                    ) { value ->
                        onEvent(HomeUiEvent.SelectedTabOption(value))
                    }
                }
            }
            if (homeState.isLoading){
                CircularProgressBar()
            }else{
                HomeBody(
                    productList = homeState.visibleProductList
                ){
                    onEvent(HomeUiEvent.OnClickedProduct(it))
                }

            }

        }

    }
}

@Preview
@Composable
fun HomeContentPreview() {
    val snackBarHostState = remember { SnackbarHostState() }
    HomeContent(
        snackBarHostState = snackBarHostState,
        homeState = HomeUiState(categoryList = listOf("all", "electronics"))
    ) {}
}

@Preview(device = PIXEL_4)
@Composable
private fun HomeContentPreviewDark(){
    ECommerecAppTheme(darkTheme = true) {
        val snackBarHostState = remember { SnackbarHostState() }
        HomeContent(
            snackBarHostState = snackBarHostState,
            homeState = HomeUiState(categoryList = listOf("all", "electronics"))
        ) {}
    }
}