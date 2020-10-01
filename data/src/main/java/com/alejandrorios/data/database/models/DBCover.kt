package com.alejandrorios.data.database.models

import androidx.room.ColumnInfo
import com.alejandrorios.domain.model.Cover

/**
 * @author alejandrorios on 9/8/20
 */
data class DBCover(
    @ColumnInfo(name = "tiny_cover") val tiny: String,
    @ColumnInfo(name = "small_cover") val small: String,
    @ColumnInfo(name = "large_cover") val large: String,
    @ColumnInfo(name = "original_cover") val original: String
) {
    fun toCover(): Cover {
        return Cover(
            tiny = tiny,
            small = small,
            large = large,
            original = original
        )
    }

    fun toDBCover(): DBCover {
        return DBCover(
            tiny = tiny,
            small = small,
            large = large,
            original = original
        )
    }
}
