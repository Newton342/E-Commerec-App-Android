package com.example.ecommerecapp.di

import com.example.ecommerecapp.data.remote.IApi
import com.example.ecommerecapp.data.repositoryimpl.GetUsersRepoImpl
import com.example.ecommerecapp.data.repositoryimpl.UserLoginRepoImpl
import com.example.ecommerecapp.domain.repositories.IGetUsersRepo
import com.example.ecommerecapp.domain.repositories.IUserLoginRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun getUsersRepo(iApi: IApi): IGetUsersRepo = GetUsersRepoImpl(iApi)

    @Singleton
    @Provides
    fun getLoginUserRepo(iApi: IApi): IUserLoginRepo = UserLoginRepoImpl(iApi)
}