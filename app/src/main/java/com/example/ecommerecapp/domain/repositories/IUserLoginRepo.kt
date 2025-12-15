package com.example.ecommerecapp.domain.repositories

import com.example.ecommerecapp.domain.model.LoginModel
import com.example.ecommerecapp.domain.model.TokenModel
import retrofit2.Response

interface IUserLoginRepo {
    suspend fun loginUser(loginModel: LoginModel) : Response<TokenModel>
}