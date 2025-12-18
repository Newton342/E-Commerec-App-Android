package com.example.ecommerecapp.presentation.screens.home

import com.example.ecommerecapp.domain.model.ProductModel

data class HomeUiState(
    val isLoading: Boolean = false,
    val isDropdownOpened: Boolean = false,
    val productList: List<ProductModel> = emptyList(),
    val categoryList : List<String> = emptyList(),
    val selectedTabValue: String = "all"
)
