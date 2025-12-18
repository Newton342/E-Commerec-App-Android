package com.example.ecommerecapp.data.repositoryimpl

import com.example.ecommerecapp.data.remote.IApi
import com.example.ecommerecapp.domain.model.User
import com.example.ecommerecapp.domain.repositories.IGetUsersRepo
import retrofit2.Response
import javax.inject.Inject

class GetUsersRepoImpl @Inject constructor(
    private val iApi : IApi
)  : IGetUsersRepo {
    override suspend fun getUsers(): Response<List<User>> {
        return  iApi.fetchUsers()
    }
}