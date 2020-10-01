package com.alejandrorios.data.database.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alejandrorios.domain.model.Anime
import com.alejandrorios.domain.model.AnimeAttributes

/**
 * @author alejandrorios on 9/8/20
 */
@Entity(tableName = "anime_favorites")
data class DBAnimeFavorites(
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

    fun toDBAnimeFavorites(): DBAnimeFavorites {
        return DBAnimeFavorites(
            id = id,
            attributes = attributes.toDBAnimeAttributes()
        )
    }
}
