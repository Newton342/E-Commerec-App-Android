package com.example.ecommerecapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.example.ecommerecapp.domain.usecases.GetAllProductUseCase
import com.example.ecommerecapp.domain.usecases.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeVm @Inject constructor(
    private val getCategory: GetCategoriesUseCase,
    private val allProduct: GetAllProductUseCase
) : ViewModel() {


}