package com.alejandrorios.data.entities

import com.alejandrorios.domain.model.Anime

/**
 * @author alejandrorios on 8/11/20
 */
data class APIAnime(
    val id: Int,
    val attributes: APIAnimeAttributes
) {
    fun toAnime(): Anime {
        return Anime(
            this.id,
            this.attributes.toAnimeAttributes()
        )
    }
}
