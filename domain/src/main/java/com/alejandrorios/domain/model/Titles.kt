package com.alejandrorios.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author alejandrorios on 8/11/20
 */
@Parcelize
data class Titles(
    val en: String?,
    val enJp: String?,
    val jaJp: String?
): Parcelable
