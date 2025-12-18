package com.example.ecommerecapp.domain.usecases

import com.example.ecommerecapp.domain.repositories.IProductRepo
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductByCategoryUseCase @Inject constructor(private val productRepo: IProductRepo) {
    operator fun invoke(category: String) = flow {
        productRepo.getProductByCategory(category).let {
            if (it.isSuccessful) {
                emit(it.body())
            }
        }
    }
}