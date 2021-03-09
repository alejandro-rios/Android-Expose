package com.alejandrorios.domain.repository

import com.alejandrorios.domain.model.Anime

/**
 * @author alejandrorios on 9/8/20
 */
interface LocalStorageRepository {

    suspend fun getAnimeFavorites(): List<Anime>

    suspend fun findAnimeFavorite(animeId: Int): Boolean

    suspend fun updateAnimeFavorites(anime: Anime)

    suspend fun removeAnimeFavorite(animeId: Int)
}
