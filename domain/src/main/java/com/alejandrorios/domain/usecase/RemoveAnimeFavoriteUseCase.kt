package com.alejandrorios.domain.usecase

import com.alejandrorios.domain.repository.LocalStorageRepository

class RemoveAnimeFavoriteUseCase(private val localStorageRepository: LocalStorageRepository) {

    suspend operator fun invoke(params: Int) {
        return localStorageRepository.removeAnimeFavorite(params)
    }
}

