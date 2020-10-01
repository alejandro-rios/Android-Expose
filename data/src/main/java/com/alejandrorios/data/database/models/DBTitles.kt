package com.alejandrorios.data.database.models

import com.alejandrorios.domain.model.Titles

/**
 * @author alejandrorios on 9/8/20
 */
data class DBTitles(
    val en: String?,
    val enJp: String?,
    val jaJp: String?
) {
    fun toTitles(): Titles {
        return Titles(
            en = en,
            enJp = enJp,
            jaJp = jaJp
        )
    }

    fun toDBTitles(): DBTitles {
        return DBTitles(
            en = en,
            enJp = enJp,
            jaJp = jaJp
        )
    }
}
