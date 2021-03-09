package com.alejandrorios.data.repository

import com.alejandrorios.data.database.dao.DBAnimeFavoritesDao
import com.alejandrorios.data.database.models.DBAnimeAttributes
import com.alejandrorios.data.database.models.DBAnimeFavoritesEntity
import com.alejandrorios.data.database.models.DBCover
import com.alejandrorios.data.database.models.DBPoster
import com.alejandrorios.data.database.models.DBTitles
import com.alejandrorios.domain.model.Anime
import com.alejandrorios.domain.repository.LocalStorageRepository

/**
 * @author alejandrorios on 9/8/20
 */
class LocalStorageRepositoryImpl(private val animeDao: DBAnimeFavoritesDao) : LocalStorageRepository {

    override suspend fun getAnimeFavorites(): List<Anime> {
        return animeDao.getAll().map { it.toAnimeFavorites() }
    }

    override suspend fun findAnimeFavorite(animeId: Int): Boolean {
        return animeDao.findById(animeId) != null
    }

    override suspend fun updateAnimeFavorites(anime: Anime) {
        // TODO: Adjust this
        val dbAnimeFavoritesEntity = DBAnimeFavoritesEntity(
            anime.id,
            DBAnimeAttributes(
                slug = anime.attributes.slug,
                synopsis = anime.attributes.synopsis,
                titles = DBTitles(
                    en = anime.attributes.titles?.en,
                    enJp = anime.attributes.titles?.enJp,
                    jaJp = anime.attributes.titles?.jaJp
                ),
                canonicalTitle = anime.attributes.slug,
                posterImage = DBPoster(
                    tiny = anime.attributes.posterImage?.tiny ?: EMPTY,
                    small = anime.attributes.posterImage?.small ?: EMPTY,
                    medium = anime.attributes.posterImage?.medium ?: EMPTY,
                    large = anime.attributes.posterImage?.large ?: EMPTY,
                    original = anime.attributes.posterImage?.original ?: EMPTY,
                ),
                coverImage = DBCover(
                    tiny = anime.attributes.coverImage?.tiny ?: EMPTY,
                    small = anime.attributes.coverImage?.small ?: EMPTY,
                    large = anime.attributes.coverImage?.large ?: EMPTY,
                    original = anime.attributes.coverImage?.original ?: EMPTY,
                ),
                episodeCount = anime.attributes.episodeCount,
                episodeLength = anime.attributes.episodeLength,
                youtubeVideoId = anime.attributes.youtubeVideoId,
                showType = anime.attributes.showType
            )
        )

        animeDao.insert(dbAnimeFavoritesEntity)
    }

    override suspend fun removeAnimeFavorite(animeId: Int) {
        animeDao.deleteItem(animeId)
    }
}

const val EMPTY = ""
