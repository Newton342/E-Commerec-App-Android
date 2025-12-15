package com.example.ecommerecapp.domain.usecases

import com.example.ecommerecapp.domain.repositories.IGetUsersRepo
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val iGetUsersRepo: IGetUsersRepo
) {
    operator fun invoke() = flow {
        iGetUsersRepo.getUsers().let {
            if (it.isSuccessful){
                emit(it.body())
            }
        }
    }
}