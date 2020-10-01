package com.alejandrorios.data.repository

import com.alejandrorios.data.service.AnimeService
import com.alejandrorios.domain.model.Anime
import com.alejandrorios.domain.repository.AnimeRepository

/**
 * @author alejandrorios on 8/11/20
 */
class AnimeRepositoryImpl(private val animeService: AnimeService) : AnimeRepository {

    override suspend fun getAnimeTrends(): List<Anime> {
        val anime = animeService.getAnimeTrends()

        return anime.data.map {
            it.toAnime()
        }
    }
}
