package com.example.ecommerecapp.domain.usecases

import com.example.ecommerecapp.domain.repositories.IProductRepo
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductUseCase @Inject constructor(private val productRepo: IProductRepo) {
    operator fun invoke(id: Int) = flow {
        productRepo.getSingleProduct(id).let {
            if (it.isSuccessful) {
                emit(it.body())
            }
        }
    }
}