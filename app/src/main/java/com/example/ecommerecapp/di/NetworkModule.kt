package com.example.ecommerecapp.di

import com.example.ecommerecapp.data.remote.IApi
import com.example.ecommerecapp.data.repositoryimpl.GetUsersRepoImpl
import com.example.ecommerecapp.domain.repositories.IGetUsersRepo
import com.example.ecommerecapp.network.BASEURL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    @Named("base_url")
    fun getBase(): String = BASEURL

    val contentType = "application/json".toMediaType()

    @Singleton
    @Provides
    fun getRetrofitClient(
        @Named("base_url") baseUrl: String
    ): Retrofit = Retrofit.Builder().addConverterFactory(Json.asConverterFactory(contentType))
        .baseUrl(baseUrl).build()

    @Singleton
    @Provides
    fun apiClient(retrofit: Retrofit): IApi = retrofit.create<IApi>(IApi::class.java)
}

