package com.example.ecommerecapp.presentation.screens.product

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerecapp.domain.model.ProductModel
import com.example.ecommerecapp.domain.usecases.GetProductByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductVm @Inject constructor(
    savedStateHandle: SavedStateHandle, private val product: GetProductByIdUseCase
) : ViewModel() {
    val id = savedStateHandle.get<Int>("id") ?: 0
    private val _uiState =
        MutableStateFlow<ProductNetworkUiState<ProductModel>>(ProductNetworkUiState.Loading)
    val state: StateFlow<ProductNetworkUiState<ProductModel>> = _uiState

    init {
        getProductById(id)
    }

    private fun getProductById(id: Int) {
        product(id).onEach {
            it?.let {
                _uiState.tryEmit(ProductNetworkUiState.Success(it))
            }
        }.catch {
            _uiState.tryEmit(ProductNetworkUiState.Error("Something went wrong"))
        }.launchIn(viewModelScope)
    }
}