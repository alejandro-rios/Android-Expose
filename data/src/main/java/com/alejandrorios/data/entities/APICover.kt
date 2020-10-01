package com.alejandrorios.data.entities

import com.alejandrorios.domain.model.Cover

/**
 * @author alejandrorios on 8/11/20
 */
data class APICover(
    val tiny: String,
    val small: String,
    val large: String,
    val original: String
) {
    fun toCover(): Cover {
        return Cover(
            this.tiny,
            this.small,
            this.large,
            this.original
        )
    }
}
