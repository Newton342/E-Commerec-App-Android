package com.example.ecommerecapp.data.remote

import com.example.ecommerecapp.domain.model.LoginModel
import com.example.ecommerecapp.domain.model.ProductModel
import com.example.ecommerecapp.domain.model.TokenModel
import com.example.ecommerecapp.domain.model.User
import com.example.ecommerecapp.network.CATEGORIES
import com.example.ecommerecapp.network.LOGIN
import com.example.ecommerecapp.network.PRODUCT
import com.example.ecommerecapp.network.PRODUCTS
import com.example.ecommerecapp.network.USERS
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface IApi {
    @GET(USERS)
    suspend fun fetchUsers(): Response<List<User>>

    @POST(LOGIN)
    suspend fun login(@Body login: LoginModel): Response<TokenModel>

    @GET(PRODUCTS)
    suspend fun getAllProducts(): Response<List<ProductModel>>

    @GET(PRODUCT)
    suspend fun getProductById(@Path("id") id: Int): Response<ProductModel>

    @GET(CATEGORIES)
    suspend fun getCategories(): Response<List<String>>
}