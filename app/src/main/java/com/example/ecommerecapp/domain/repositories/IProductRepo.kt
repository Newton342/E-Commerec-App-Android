package com.example.ecommerecapp.domain.repositories

import com.example.ecommerecapp.domain.model.ProductModel
import retrofit2.Response

interface IProductRepo {
    suspend fun getAllProducts(): Response<List<ProductModel>>

    suspend fun getSingleProduct(id:Int): Response<ProductModel>

    suspend fun getProductCategories (): Response<List<String>>

}