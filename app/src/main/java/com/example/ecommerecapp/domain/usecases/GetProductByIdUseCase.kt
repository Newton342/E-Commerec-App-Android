package com.example.ecommerecapp.domain.usecases

import com.example.ecommerecapp.domain.repositories.IProductRepo
import jakarta.inject.Inject
import kotlinx.coroutines.flow.flow

class GetProductByIdUseCase @Inject constructor(
    private val productRepo: IProductRepo
) {
    operator fun invoke(id: Int)= flow {
        productRepo.getSingleProduct(id).let {
            if (it.isSuccessful){
                emit(it.body())
            }
        }
    }
}