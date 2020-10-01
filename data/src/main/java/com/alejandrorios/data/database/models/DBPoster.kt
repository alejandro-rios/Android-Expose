package com.alejandrorios.data.database.models

import androidx.room.ColumnInfo
import com.alejandrorios.domain.model.Poster

/**
 * @author alejandrorios on 9/8/20
 */
data class DBPoster(
    @ColumnInfo(name = "tiny_poster") val tiny: String,
    @ColumnInfo(name = "small_poster") val small: String,
    val medium: String,
    @ColumnInfo(name = "large_poster") val large: String,
    @ColumnInfo(name = "original_poster") val original: String
) {
    fun toPoster(): Poster {
        return Poster(
            tiny = tiny,
            small = small,
            medium = medium,
            large = large,
            original = original
        )
    }

    fun toDBPoster(): DBPoster {
        return DBPoster(
            tiny = tiny,
            small = small,
            medium = medium,
            large = large,
            original = original
        )
    }
}
