package com.example.ecommerecapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerecapp.domain.usecases.GetAllProductUseCase
import com.example.ecommerecapp.domain.usecases.GetCategoriesUseCase
import com.example.ecommerecapp.domain.usecases.GetProductByCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeVm @Inject constructor(
    private val getCategory: GetCategoriesUseCase,
    private val allProduct: GetAllProductUseCase,
    private val productByCategory: GetProductByCategoryUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val state: StateFlow<HomeUiState> = _uiState

    private val _homeEffect = Channel<HomeEffect>()
    val homeEffect = _homeEffect.receiveAsFlow()

    init {
        fetchAllData()
    }


    fun fetchAllData() {
        _uiState.update { it.copy(isLoading = true) }
        allProduct().combine(getCategory()) { products, categories ->
            _uiState.tryEmit(
                HomeUiState(
                    productList = products ?: emptyList(), categoryList = categories ?: emptyList()
                )
            )
        }.catch {
            _homeEffect.send(HomeEffect.ShowSnackBar("Something went wrong"))

        }.launchIn(viewModelScope)
        _uiState.update { it.copy(isLoading = false) }
    }

    fun fetchSortedProduct(sort: String? = null) {
        _uiState.update { it.copy(isLoading = true) }

        val defaultAscSort = if (sort != null && sort == "asc") null else sort
        allProduct(defaultAscSort).catch {
            _homeEffect.send(HomeEffect.ShowSnackBar("Something went wrong"))
        }.onEach { productList ->
            _uiState.tryEmit(
                HomeUiState(
                    isLoading = false,
                    productList = productList ?: emptyList()
                )
            )
        }.launchIn(viewModelScope)
    }

    fun onEvent(events: HomeUiEvent) {
        when (events) {
            is HomeUiEvent.ToggleDropDown -> {
                _uiState.update { it.copy(isDropdownOpened = events.state) }
            }

            is HomeUiEvent.SearchProductByName -> {

            }
            is HomeUiEvent.SelectedDropdownValue -> {
                fetchSortedProduct(events.value)
            }

            is HomeUiEvent.SelectedTabOption -> {
                _uiState.update { it.copy(isLoading = true) }
                productByCategory(events.value).catch {
                    _homeEffect.send(HomeEffect.ShowSnackBar("Something went wrong"))
                }.onEach { productList ->
                    _uiState.update { it.copy(productList = productList ?: emptyList()) }
                }.launchIn(viewModelScope)
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }
}