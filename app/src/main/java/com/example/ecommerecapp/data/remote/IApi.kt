package com.example.ecommerecapp.data.remote

import com.example.ecommerecapp.domain.model.LoginModel
import com.example.ecommerecapp.domain.model.ProductModel
import com.example.ecommerecapp.domain.model.TokenModel
import com.example.ecommerecapp.domain.model.User
import com.example.ecommerecapp.network.CATEGORIES
import com.example.ecommerecapp.network.LOGIN
import com.example.ecommerecapp.network.PRODUCTS
import com.example.ecommerecapp.network.PRODUCTS_BY_CATEGORY
import com.example.ecommerecapp.network.PRODUCT_BY_ID
import com.example.ecommerecapp.network.USERS
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface IApi {
    @GET(USERS)
    suspend fun fetchUsers(): Response<List<User>>

    @POST(LOGIN)
    suspend fun login(@Body login: LoginModel): Response<TokenModel>

    @GET(PRODUCTS)
    suspend fun getAllProducts(@Query("sort") sort:String? = null): Response<List<ProductModel>>

    @GET(PRODUCT_BY_ID)
    suspend fun getProductById(@Path("id") id: Int): Response<ProductModel>

    @GET(CATEGORIES)
    suspend fun getCategories(): Response<List<String>>

    @GET(PRODUCTS_BY_CATEGORY)
    suspend fun getProductsByCategory(@Path("category") category:String): Response<List<ProductModel>>
}