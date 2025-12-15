package com.example.ecommerecapp.presentation.screens.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerecapp.domain.model.User
import com.example.ecommerecapp.domain.usecases.GetUsersUseCase
import com.example.ecommerecapp.network.NetworkUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UsersVm @Inject constructor(
    private val userUseCase: GetUsersUseCase
) : ViewModel() {
    var userData = MutableStateFlow<NetworkUIState<List<User>>>(NetworkUIState.Loading())
        private set

    init {
        getUsers()
    }

    private fun getUsers() {
        userUseCase().onEach { users ->
            users?.let {
                userData.tryEmit(NetworkUIState.Success(it))
            }
        }.catch { e -> userData.tryEmit(NetworkUIState.Error("Something went wrong")) }
            .launchIn(viewModelScope)
    }
}