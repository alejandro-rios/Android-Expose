package com.alejandrorios.domain.usecase

import com.alejandrorios.domain.model.Anime
import com.alejandrorios.domain.repository.AnimeRepository

/**
 * @author alejandrorios on 8/11/20
 */
class GetAnimeTrendsUseCase(private val animeRepository: AnimeRepository) {

    suspend operator fun invoke(): List<Anime> {
        return animeRepository.getAnimeTrends()
    }
}
