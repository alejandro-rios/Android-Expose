package com.alejandrorios.data.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.alejandrorios.data.database.dao.DBAnimeFavoritesDao
import com.alejandrorios.data.database.models.DBAnimeAttributes
import com.alejandrorios.data.database.models.DBAnimeFavorites
import com.alejandrorios.data.database.models.DBCover
import com.alejandrorios.data.database.models.DBPoster
import com.alejandrorios.data.database.models.DBTitles
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

/**
 * @author alejandrorios on 9/8/20
 */
@RunWith(AndroidJUnit4::class)
class DBAnimeFavoritesDaoTest {

    private lateinit var dao: DBAnimeFavoritesDao
    private lateinit var db: AnimeExposeDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AnimeExposeDatabase::class.java
        ).build()

        dao = db.getDBAnimeFavoritesDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun whenAnimeFavoritesIsInsertedThenDBShouldReturnTheSameData() {
        val dbAnimeFavoritesSource = DBAnimeFavorites(
            id = 41370,
            attributes = DBAnimeAttributes(
                slug = "kimetsu-no-yaiba",
                synopsis = """It is the Taisho Period in Japan. Tanjiro, a kindhearted boy who sells charcoal for a living, finds his family slaughtered by a demon. To make matters worse, his younger sister Nezuko, the sole survivor, has been transformed into a demon herself. Though devastated by this grim reality, Tanjiro resolves to become a “demon slayer” so that he can turn his sister back into a human, and kill the demon that massacred his family.\r\n\r\n(Source: Crunchyroll)""",
                titles = DBTitles(
                    en = "Demon Slayer: Kimetsu no Yaiba",
                    enJp = "Kimetsu no Yaiba",
                    jaJp = "鬼滅の刃"
                ),
                canonicalTitle = "Kimetsu no Yaiba",
                posterImage = DBPoster(
                    tiny = "https://media.kitsu.io/anime/poster_images/41370/tiny.jpg?1553005025",
                    small = "https://media.kitsu.io/anime/poster_images/41370/small.jpg?1553005025",
                    medium = "https://media.kitsu.io/anime/poster_images/41370/medium.jpg?1553005025",
                    large = "https://media.kitsu.io/anime/poster_images/41370/large.jpg?1553005025",
                    original = "https://media.kitsu.io/anime/poster_images/41370/original.jpg?1553005025"
                ),
                coverImage = DBCover(
                    tiny = "https://media.kitsu.io/anime/cover_images/41370/tiny.jpg?1527760997",
                    small = "https://media.kitsu.io/anime/cover_images/41370/small.jpg?1527760997",
                    large = "https://media.kitsu.io/anime/cover_images/41370/large.jpg?1527760997",
                    original = "https://media.kitsu.io/anime/cover_images/41370/original.jpg?1527760997"
                ),
                episodeCount = 26,
                episodeLength = 23,
                youtubeVideoId = "vxoO30azT3I",
                showType = "TV"
            )
        )

        dao.insert(dbAnimeFavoritesSource)

        val result = dao.getAll()
        assertEquals(result[0], dbAnimeFavoritesSource)
    }
}
