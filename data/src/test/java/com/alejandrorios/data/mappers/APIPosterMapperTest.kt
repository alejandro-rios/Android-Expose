package com.alejandrorios.data.mappers

import com.alejandrorios.data.entities.APIPoster
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

/**
 * @author alejandrorios on 8/11/20
 */
class APIPosterMapperTest {
    @Test
    fun `when toPoster it's called then should return Poster model`() {
        // GIVEN
        val apiPosterSource = APIPoster(
            tiny = "https://media.kitsu.io/anime/poster_images/41370/tiny.jpg?1553005025",
            small = "https://media.kitsu.io/anime/poster_images/41370/small.jpg?1553005025",
            medium = "https://media.kitsu.io/anime/poster_images/41370/medium.jpg?1553005025",
            large = "https://media.kitsu.io/anime/poster_images/41370/large.jpg?1553005025",
            original = "https://media.kitsu.io/anime/poster_images/41370/original.jpg?1553005025"
        )

        // WHEN
        val result = apiPosterSource.toPoster()

        // THEN
        with(result) {
            this.tiny shouldBeEqualTo "https://media.kitsu.io/anime/poster_images/41370/tiny.jpg?1553005025"
            this.small shouldBeEqualTo "https://media.kitsu.io/anime/poster_images/41370/small.jpg?1553005025"
            this.medium shouldBeEqualTo "https://media.kitsu.io/anime/poster_images/41370/medium.jpg?1553005025"
            this.large shouldBeEqualTo "https://media.kitsu.io/anime/poster_images/41370/large.jpg?1553005025"
            this.original shouldBeEqualTo "https://media.kitsu.io/anime/poster_images/41370/original.jpg?1553005025"
        }
    }
}
