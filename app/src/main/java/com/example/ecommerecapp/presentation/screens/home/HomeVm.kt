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
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
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


    fun fetchAllData(sort: String? = null) {
        val defaultAscSort = if (sort != null && sort == "asc") null else sort
        allProduct(defaultAscSort).combine(getCategory()) { products, categories ->
            HomeUiState(
                productList = products.orEmpty(),
                visibleProductList = products.orEmpty(),
                categoryList = listOf("all") + categories.orEmpty()
            )
        }.onStart {
            _uiState.update { it.copy(isLoading = true) }
        }.onEach { newState -> _uiState.value = newState }.catch {
            _uiState.update { it.copy(isLoading = false) }
            _homeEffect.send(HomeEffect.ShowSnackBar("Something went wrong"))

        }.onCompletion {
            _uiState.update { it.copy(isLoading = false) }
        }.launchIn(viewModelScope)

    }


    fun onSearchQueryChanged(query: String) {
        _uiState.update { state ->
            val visibleList = if (query.isBlank()) {
                state.productList
            } else {
                state.productList.filter {
                    it.title?.contains(query, ignoreCase = true) == true
                }
            }

            state.copy(
                visibleProductList = visibleList
            )
        }
    }

    fun fetchProductByCategory(category: String) {

        productByCategory(category).catch {
            _uiState.update { it.copy(isLoading = false) }
            _homeEffect.send(HomeEffect.ShowSnackBar("Something went wrong"))
        }.onStart {
            _uiState.update { it.copy(isLoading = true) }
        }.onEach { productList ->
            _uiState.update {
                it.copy(
                    productList = productList.orEmpty(),
                    visibleProductList = productList.orEmpty()
                )
            }
        }.onCompletion {
            _uiState.update { it.copy(isLoading = false) }
        }.launchIn(viewModelScope)
    }

    fun onEvent(events: HomeUiEvent) {
        when (events) {
            is HomeUiEvent.ToggleDropDown -> {
                _uiState.update { it.copy(isDropdownOpened = events.state) }
            }

            is HomeUiEvent.SearchProductByName -> {
                onSearchQueryChanged(events.name)
            }

            is HomeUiEvent.SelectedDropdownValue -> {
                fetchAllData(events.value)
            }

            is HomeUiEvent.SelectedTabOption -> {
                _uiState.update { it.copy(selectedTabValue = events.value) }
                if (events.value == "all") {
                    fetchAllData()
                } else {
                    fetchProductByCategory(events.value)
                }
            }
        }
    }
}