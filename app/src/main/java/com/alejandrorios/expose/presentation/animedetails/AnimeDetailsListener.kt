package com.alejandrorios.expose.presentation.animedetails

import com.alejandrorios.domain.model.Anime

/**
 * @author alejandrorios on 8/18/20
 */
interface AnimeDetailsListener {

    fun onAnimeTrendClicked(anime: Anime)
}
