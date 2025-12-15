package com.example.ecommerecapp.domain.repositories

import com.example.ecommerecapp.domain.model.User
import retrofit2.Response

interface IGetUsersRepo {
    suspend fun getUsers(): Response<List<User>>
}