package com.alejandrorios.data.entities

import com.alejandrorios.domain.model.AnimeAttributes

/**
 * @author alejandrorios on 8/15/20
 */
data class APIAnimeAttributes(
    val slug: String?,
    val synopsis: String?,
    val titles: APITitles?,
    val canonicalTitle: String?,
    val posterImage: APIPoster?,
    val coverImage: APICover?,
    val episodeCount: Int,
    val episodeLength: Int,
    val youtubeVideoId: String?,
    val showType: String?
) {

    fun toAnimeAttributes(): AnimeAttributes {
        return AnimeAttributes(
            this.slug,
            this.synopsis,
            this.titles?.toTitles(),
            this.canonicalTitle,
            this.posterImage?.toPoster(),
            this.coverImage?.toCover(),
            this.episodeCount,
            this.episodeLength,
            this.youtubeVideoId,
            this.showType
        )
    }
}
