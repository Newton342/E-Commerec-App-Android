package com.example.ecommerecapp.data.repositoryimpl

import com.example.ecommerecapp.data.remote.IApi
import com.example.ecommerecapp.domain.model.LoginModel
import com.example.ecommerecapp.domain.model.TokenModel
import com.example.ecommerecapp.domain.repositories.IUserLoginRepo
import retrofit2.Response
import javax.inject.Inject

class UserLoginRepoImpl @Inject constructor(
    private val iApi: IApi
) : IUserLoginRepo {
    override suspend fun loginUser(loginModel: LoginModel): Response<TokenModel> {
        return iApi.login(loginModel)
    }
}