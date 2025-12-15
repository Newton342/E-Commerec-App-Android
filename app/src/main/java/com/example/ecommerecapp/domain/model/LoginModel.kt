package com.example.ecommerecapp.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginModel(
    @SerialName("password")
    val password: String,
    @SerialName("username")
    val username: String
)