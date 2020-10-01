package com.alejandrorios.data.entities

import com.alejandrorios.domain.model.Poster

/**
 * @author alejandrorios on 8/11/20
 */
data class APIPoster(
    val tiny: String,
    val small: String,
    val medium: String,
    val large: String,
    val original: String
) {
    fun toPoster(): Poster {
        return Poster(
            this.tiny,
            this.small,
            this.medium,
            this.large,
            this.original
        )
    }
}

