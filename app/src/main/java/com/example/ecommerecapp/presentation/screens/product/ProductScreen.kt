package com.example.ecommerecapp.presentation.screens.product

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ecommerecapp.domain.model.ProductModel
import com.example.ecommerecapp.presentation.components.CircularProgressBar
import com.example.ecommerecapp.presentation.screens.product.components.ProductContent

@Composable
fun ProductScreen(navController: NavController, productVm: ProductVm = hiltViewModel()) {
    val state by productVm.state.collectAsState()
    Log.i("Product","====$state")
    when (val uiState = state) {
        is ProductNetworkUiState.Error -> {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(uiState.message, textAlign = TextAlign.Center)
            }
        }
        ProductNetworkUiState.Loading -> {
            CircularProgressBar()
        }
        is ProductNetworkUiState.Success<ProductModel> -> {
            ProductContent(productData = uiState.data) {
                navController.popBackStack()
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ProductScreenPreview() {
    val navController = rememberNavController()
    ProductScreen(navController)
}