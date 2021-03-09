package com.alejandrorios.data.database.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alejandrorios.domain.model.Anime

/**
 * @author alejandrorios on 9/8/20
 */
@Entity(tableName = "anime_favorites")
data class DBAnimeFavoritesEntity(
    @PrimaryKey
    val id: Int,
    @Embedded val attributes: DBAnimeAttributes,
) {
    fun toAnimeFavorites(): Anime {
        return Anime(
            id = id,
            attributes = attributes.toAnimeAttributes()
        )
    }
}
