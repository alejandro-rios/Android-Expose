package com.alejandrorios.domain.usecase

import com.alejandrorios.domain.repository.LocalStorageRepository

class IsAnimeFavoriteUseCase(private val localStorageRepository: LocalStorageRepository) {

    suspend operator fun invoke(params: Int): Boolean {
        return localStorageRepository.findAnimeFavorite(params)
    }
}
