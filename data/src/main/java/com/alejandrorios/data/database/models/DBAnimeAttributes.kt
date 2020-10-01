package com.alejandrorios.data.database.models

import androidx.room.Embedded
import androidx.room.Entity
import com.alejandrorios.domain.model.AnimeAttributes
import com.alejandrorios.domain.model.Cover
import com.alejandrorios.domain.model.Poster
import com.alejandrorios.domain.model.Titles

/**
 * @author alejandrorios on 9/8/20
 */
data class DBAnimeAttributes(
    val slug: String?,
    val synopsis: String?,
    @Embedded val titles: DBTitles?,
    val canonicalTitle: String?,
    @Embedded val posterImage: DBPoster?,
    @Embedded val coverImage: DBCover?,
    val episodeCount: Int,
    val episodeLength: Int,
    val youtubeVideoId: String?,
    val showType: String?
) {
    fun toAnimeAttributes(): AnimeAttributes {
        return AnimeAttributes(
            slug = slug,
            synopsis = synopsis,
            titles = titles?.toTitles(),
            canonicalTitle = canonicalTitle,
            posterImage = posterImage?.toPoster(),
            coverImage = coverImage?.toCover(),
            episodeCount = episodeCount,
            episodeLength = episodeLength,
            youtubeVideoId = youtubeVideoId,
            showType = showType
        )
    }

    fun toDBAnimeAttributes(): DBAnimeAttributes {
        return DBAnimeAttributes(
            slug = slug,
            synopsis = synopsis,
            titles = titles?.toDBTitles(),
            canonicalTitle = canonicalTitle,
            posterImage = posterImage?.toDBPoster(),
            coverImage = coverImage?.toDBCover(),
            episodeCount = episodeCount,
            episodeLength = episodeLength,
            youtubeVideoId = youtubeVideoId,
            showType = showType
        )
    }
}
