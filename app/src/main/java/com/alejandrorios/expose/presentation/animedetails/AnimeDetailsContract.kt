package com.alejandrorios.expose.presentation.animedetails

import com.alejandrorios.domain.model.Anime
import com.alejandrorios.expose.utils.base.BasePresenter
import com.alejandrorios.expose.utils.base.BaseView

/**
 * @author alejandrorios on 8/18/20
 */
interface AnimeDetailsContract {

    interface View: BaseView {

        fun displayAnimeDetails(anime: Anime)

        fun markAsFavorite()

        fun unMarkAsFavorite()
    }

    interface Presenter: BasePresenter<View> {

        fun onViewCreated(anime: Anime)

        fun processFavorite(anime: Anime)
    }
}
