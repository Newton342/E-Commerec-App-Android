package com.example.ecommerecapp.data.repositoryimpl

import com.example.ecommerecapp.data.remote.IApi
import com.example.ecommerecapp.domain.model.ProductModel
import com.example.ecommerecapp.domain.repositories.IProductRepo
import retrofit2.Response
import javax.inject.Inject

class ProductsRepoImpl @Inject constructor(
    private val iApi: IApi
) : IProductRepo{
    override suspend fun getAllProducts(sort:String?): Response<List<ProductModel>> {
        return iApi.getAllProducts(sort)
    }

    override suspend fun getSingleProduct(id: Int): Response<ProductModel> {
        return iApi.getProductById(id)
    }

    override suspend fun getProductCategories(): Response<List<String>> {
        return iApi.getCategories()
    }

    override suspend fun getProductByCategory(category: String): Response<List<ProductModel>> {
        return iApi.getProductsByCategory(category)
    }
}