package com.example.ecommerecapp.presentation.screens.home

sealed interface HomeUiEvent {
    data class ToggleDropDown(val state: Boolean) : HomeUiEvent
    data class SelectedDropdownValue(val value: String): HomeUiEvent
    data class SearchProductByName(val name: String): HomeUiEvent
    data class SelectedTabOption(val value: String): HomeUiEvent
    data class OnClickedProduct(val index: Int): HomeUiEvent
}