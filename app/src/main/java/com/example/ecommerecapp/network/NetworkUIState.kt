package com.example.ecommerecapp.network

sealed class NetworkUIState<T> {
    class Loading<T> : NetworkUIState<T>()
    data class Success<T>(val data : T): NetworkUIState<T>()
    data class Error<T>(val error: String) : NetworkUIState<T>()
}