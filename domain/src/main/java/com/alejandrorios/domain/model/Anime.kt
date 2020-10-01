package com.alejandrorios.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author alejandrorios on 8/11/20
 */
@Parcelize
data class Anime(
    val id: Int,
    val attributes: AnimeAttributes
): Parcelable
