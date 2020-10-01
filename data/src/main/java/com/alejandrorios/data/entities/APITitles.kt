package com.alejandrorios.data.entities

import com.alejandrorios.domain.model.Titles
import com.google.gson.annotations.SerializedName

/**
 * @author alejandrorios on 8/11/20
 */
data class APITitles(
    val en: String? = "",
    @SerializedName("en_jp")
    val enJp: String? = "",
    @SerializedName("ja_jp")
    val jaJp: String? = ""
) {
    fun toTitles(): Titles {
        return Titles(
            this.en,
            this.enJp,
            this.jaJp
        )
    }
}
