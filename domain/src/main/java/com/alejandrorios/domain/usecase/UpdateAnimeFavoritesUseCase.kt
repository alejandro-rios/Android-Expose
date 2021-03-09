package com.alejandrorios.domain.usecase

import com.alejandrorios.domain.model.Anime
import com.alejandrorios.domain.repository.LocalStorageRepository

/**
 * @author alejandrorios on 11/03/20
 */
class UpdateAnimeFavoritesUseCase(private val localStorageRepository: LocalStorageRepository) {

    suspend operator fun invoke(params: Anime) {
        return localStorageRepository.updateAnimeFavorites(params)
    }
}
