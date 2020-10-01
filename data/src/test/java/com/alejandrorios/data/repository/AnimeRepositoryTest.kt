package com.alejandrorios.data.repository

import com.alejandrorios.data.entities.APIAnime
import com.alejandrorios.data.entities.APIAnimeAttributes
import com.alejandrorios.data.entities.APICover
import com.alejandrorios.data.entities.APIPoster
import com.alejandrorios.data.entities.APITitles
import com.alejandrorios.data.service.AnimeService
import com.alejandrorios.domain.model.AnimeAttributes
import com.alejandrorios.domain.model.Cover
import com.alejandrorios.domain.model.Poster
import com.alejandrorios.domain.model.Titles
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Test

/**
 * @author alejandrorios on 8/11/20
 */
class AnimeRepositoryTest {

    @MockK
    lateinit var animeService: AnimeService

    init {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Before
    fun setup() {
        coEvery {
            animeService.getAnimeTrends().data
        } answers {
            listOf(
                APIAnime(
                    id = 41370,
                    attributes = APIAnimeAttributes(
                        slug = "kimetsu-no-yaiba",
                        synopsis = """It is the Taisho Period in Japan. Tanjiro, a kindhearted boy who sells charcoal for a living, finds his family slaughtered by a demon. To make matters worse, his younger sister Nezuko, the sole survivor, has been transformed into a demon herself. Though devastated by this grim reality, Tanjiro resolves to become a “demon slayer” so that he can turn his sister back into a human, and kill the demon that massacred his family.\r\n\r\n(Source: Crunchyroll)""",
                        titles = APITitles(
                            en = "Demon Slayer: Kimetsu no Yaiba",
                            enJp = "Kimetsu no Yaiba",
                            jaJp = "鬼滅の刃"
                        ),
                        canonicalTitle = "Kimetsu no Yaiba",
                        posterImage = APIPoster(
                            tiny = "https://media.kitsu.io/anime/poster_images/41370/tiny.jpg?1553005025",
                            small = "https://media.kitsu.io/anime/poster_images/41370/small.jpg?1553005025",
                            medium = "https://media.kitsu.io/anime/poster_images/41370/medium.jpg?1553005025",
                            large = "https://media.kitsu.io/anime/poster_images/41370/large.jpg?1553005025",
                            original = "https://media.kitsu.io/anime/poster_images/41370/original.jpg?1553005025"
                        ),
                        coverImage = APICover(
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
            )
        }
    }

    @Test
    fun `given repository when getAnimeTrends it's called then should get a list of APIAnime`() {
        val repository = AnimeRepositoryImpl(animeService)

        val result =
            runBlocking {
                repository.getAnimeTrends()
            }

        with(result.first()) {
            id shouldBeEqualTo 41370

            with(attributes) {
                slug shouldBeEqualTo "kimetsu-no-yaiba"
                synopsis shouldBeEqualTo """It is the Taisho Period in Japan. Tanjiro, a kindhearted boy who sells charcoal for a living, finds his family slaughtered by a demon. To make matters worse, his younger sister Nezuko, the sole survivor, has been transformed into a demon herself. Though devastated by this grim reality, Tanjiro resolves to become a “demon slayer” so that he can turn his sister back into a human, and kill the demon that massacred his family.\r\n\r\n(Source: Crunchyroll)"""

                with(titles) {
                    this?.en shouldBeEqualTo "Demon Slayer: Kimetsu no Yaiba"
                    this?.enJp shouldBeEqualTo "Kimetsu no Yaiba"
                    this?.jaJp shouldBeEqualTo "鬼滅の刃"
                }

                canonicalTitle shouldBeEqualTo "Kimetsu no Yaiba"

                with(posterImage) {
                    this?.tiny shouldBeEqualTo "https://media.kitsu.io/anime/poster_images/41370/tiny.jpg?1553005025"
                    this?.small shouldBeEqualTo "https://media.kitsu.io/anime/poster_images/41370/small.jpg?1553005025"
                    this?.medium shouldBeEqualTo "https://media.kitsu.io/anime/poster_images/41370/medium.jpg?1553005025"
                    this?.large shouldBeEqualTo "https://media.kitsu.io/anime/poster_images/41370/large.jpg?1553005025"
                    this?.original shouldBeEqualTo "https://media.kitsu.io/anime/poster_images/41370/original.jpg?1553005025"
                }

                with(coverImage) {
                    this?.tiny shouldBeEqualTo "https://media.kitsu.io/anime/cover_images/41370/tiny.jpg?1527760997"
                    this?.small shouldBeEqualTo "https://media.kitsu.io/anime/cover_images/41370/small.jpg?1527760997"
                    this?.large shouldBeEqualTo "https://media.kitsu.io/anime/cover_images/41370/large.jpg?1527760997"
                    this?.original shouldBeEqualTo "https://media.kitsu.io/anime/cover_images/41370/original.jpg?1527760997"
                }

                episodeCount shouldBeEqualTo 26
                episodeLength shouldBeEqualTo 23
                youtubeVideoId shouldBeEqualTo "vxoO30azT3I"
                showType shouldBeEqualTo "TV"
            }
        }

        coVerify {
            animeService.getAnimeTrends()
        }
    }
}
