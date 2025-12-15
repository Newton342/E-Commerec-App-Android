package com.example.ecommerecapp.domain.usecases

import com.example.ecommerecapp.domain.model.LoginModel
import com.example.ecommerecapp.domain.repositories.IUserLoginRepo
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val userLogin: IUserLoginRepo
) {
    operator fun invoke(loginModel: LoginModel) = flow{
        userLogin.loginUser(loginModel).let {
            if (it.isSuccessful){
                emit(it.body())
            }
        }
    }
}