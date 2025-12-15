package com.example.ecommerecapp.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenModel(
    @SerialName("token")
    val token: String?
)