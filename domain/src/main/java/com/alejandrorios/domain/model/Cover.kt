package com.alejandrorios.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author alejandrorios on 8/11/20
 */
@Parcelize
data class Cover(
    val tiny: String,
    val small: String,
    val large: String,
    val original: String
): Parcelable
