package com.example.ecommerecapp.presentation.screens.product

sealed class ProductNetworkUiState<out T> {
    object Loading : ProductNetworkUiState<Nothing>()
    data class Success<T>(val data: T) : ProductNetworkUiState<T>()
    data class Error(val message: String) : ProductNetworkUiState<Nothing>()


}