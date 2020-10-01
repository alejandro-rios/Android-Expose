package com.alejandrorios.data.mappers

import com.alejandrorios.data.entities.APITitles
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

/**
 * @author alejandrorios on 8/11/20
 */
class APITitlesMapperTest {
    @Test
    fun `when toTitles it's called then should return Titles model`() {
        // GIVEN
        val apiTitlesSource = APITitles(
            en = "Demon Slayer: Kimetsu no Yaiba",
            enJp = "Kimetsu no Yaiba",
            jaJp = "鬼滅の刃"
        )

        // WHEN
        val result = apiTitlesSource.toTitles()

        // THEN
        with(result) {
            this.en shouldBeEqualTo "Demon Slayer: Kimetsu no Yaiba"
            this.enJp shouldBeEqualTo "Kimetsu no Yaiba"
            this.jaJp shouldBeEqualTo "鬼滅の刃"
        }
    }
}
