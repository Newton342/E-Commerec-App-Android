package com.example.ecommerecapp.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Geolocation(
    @SerialName("lat")
    val lat: String?,
    @SerialName("long")
    val long: String?
)