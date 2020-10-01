package com.alejandrorios.domain.repository

import com.alejandrorios.domain.model.Anime

/**
 * @author alejandrorios on 8/11/20
 */
interface AnimeRepository {

    suspend fun getAnimeTrends(): List<Anime>
}
