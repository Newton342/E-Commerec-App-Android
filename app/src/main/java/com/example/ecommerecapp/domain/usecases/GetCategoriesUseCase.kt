package com.example.ecommerecapp.domain.usecases

import com.example.ecommerecapp.domain.repositories.IProductRepo
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val productRepo : IProductRepo
) {
    operator fun invoke() = flow {
        productRepo.getProductCategories().let {
            if (it.isSuccessful){
                emit(it.body())
            }
        }
    }
}