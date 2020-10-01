package com.alejandrorios.data.mappers

import com.alejandrorios.data.entities.APICover
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

/**
 * @author alejandrorios on 8/11/20
 */
class APICoverMapperTest {
    @Test
    fun `when toCover it's called then should return Cover model`() {
        // GIVEN
        val apiCoverSource = APICover(
            tiny = "https://media.kitsu.io/anime/cover_images/41370/tiny.jpg?1527760997",
            small = "https://media.kitsu.io/anime/cover_images/41370/small.jpg?1527760997",
            large = "https://media.kitsu.io/anime/cover_images/41370/large.jpg?1527760997",
            original = "https://media.kitsu.io/anime/cover_images/41370/original.jpg?1527760997"
        )

        // WHEN
        val result = apiCoverSource.toCover()

        // THEN
        with(result) {
            this.tiny shouldBeEqualTo "https://media.kitsu.io/anime/cover_images/41370/tiny.jpg?1527760997"
            this.small shouldBeEqualTo "https://media.kitsu.io/anime/cover_images/41370/small.jpg?1527760997"
            this.large shouldBeEqualTo "https://media.kitsu.io/anime/cover_images/41370/large.jpg?1527760997"
            this.original shouldBeEqualTo "https://media.kitsu.io/anime/cover_images/41370/original.jpg?1527760997"
        }
    }
}
