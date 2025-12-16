package com.example.ecommerecapp.presentation.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerecapp.domain.model.LoginModel
import com.example.ecommerecapp.domain.model.TokenModel
import com.example.ecommerecapp.domain.usecases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginVm @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    private val _uiEvent = MutableSharedFlow<LoginUiEvent>()
    val uiEvent: SharedFlow<LoginUiEvent> = _uiEvent

    private fun login(loginData: LoginModel) {

        loginUseCase(loginData).onEach { token ->
            _uiState.update { it.copy(isLoading = true) }
            if (token is TokenModel) {
                _uiEvent.emit(LoginUiEvent.NavigateToHomeScreen)
            } else {
                _uiEvent.emit(LoginUiEvent.ShowSnackBar("Invalid credentials"))
            }
            _uiState.update { it.copy(isLoading = false) }
        }.catch {
            _uiEvent.emit(LoginUiEvent.ShowSnackBar("Something went wrong"))
        }.launchIn(viewModelScope)
    }

    fun onLogin(username: String, password: String) {
        val userNameError = if (username.isBlank()) "Username required" else null
        val passwordError = if (password.isBlank()) "Username required" else null
        if (userNameError != null || passwordError != null) {
            _uiState.update {
                it.copy(
                    usernameError = userNameError, passwordError = passwordError
                )
            }
            return
        }
        val userCred = LoginModel(password = password, username = username)
        login(userCred)
    }

    fun togglePasswordVisibility(isVisible: Boolean) {
        _uiState.update {
            it.copy(isPasswordVisible = isVisible)
        }
    }

}