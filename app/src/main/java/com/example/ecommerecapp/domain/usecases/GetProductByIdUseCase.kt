package com.example.ecommerecapp.domain.usecases

import com.example.ecommerecapp.domain.model.ProductModel
import com.example.ecommerecapp.domain.repositories.IProductRepo
import com.example.ecommerecapp.presentation.screens.product.ProductNetworkUiState
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class GetProductByIdUseCase @Inject constructor(
    private val productRepo: IProductRepo
) {
    operator fun invoke(id: Int): Flow<ProductNetworkUiState<ProductModel>> = flow {
//        productRepo.getSingleProduct(id).let {
//            if (it.isSuccessful){
//                emit(it.body())
//            }
//        }
        emit(ProductNetworkUiState.Loading)
        val response = productRepo.getSingleProduct(id)
        if (response.isSuccessful) {
            emit(ProductNetworkUiState.Success(response.body()!!))
        } else {
            emit(ProductNetworkUiState.Error("API Error"))
        }
    }.catch {
        emit(ProductNetworkUiState.Error("Network Error"))

    }
}