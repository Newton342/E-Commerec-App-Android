package com.example.ecommerecapp.domain.repositories

import com.example.ecommerecapp.domain.model.ProductModel
import retrofit2.Response

interface IProductRepo {
    suspend fun getAllProducts(sort:String?= null): Response<List<ProductModel>>

    suspend fun getSingleProduct(id:Int): Response<ProductModel>

    suspend fun getProductCategories (): Response<List<String>>

    suspend fun getProductByCategory (category: String): Response<List<ProductModel>>
}