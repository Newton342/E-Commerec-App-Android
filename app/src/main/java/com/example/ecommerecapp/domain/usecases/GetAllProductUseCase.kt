package com.example.ecommerecapp.domain.usecases

import com.example.ecommerecapp.domain.repositories.IProductRepo
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllProductUseCase @Inject constructor(
    private val product: IProductRepo
) {

    operator fun invoke() = flow {
        product.getAllProducts().let {
            if (it.isSuccessful) {
                emit(it.body())
            }
        }
    }
}