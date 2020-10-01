package com.alejandrorios.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author alejandrorios on 8/15/20
 */
@Parcelize
data class AnimeAttributes(
    val slug: String?,
    val synopsis: String?,
    val titles: Titles?,
    val canonicalTitle: String?,
    val posterImage: Poster?,
    val coverImage: Cover?,
    val episodeCount: Int,
    val episodeLength: Int,
    val youtubeVideoId: String?,
    val showType: String?
): Parcelable
