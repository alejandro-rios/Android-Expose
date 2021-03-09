package com.alejandrorios.expose.presentation.favorites

import com.alejandrorios.domain.model.Anime
import com.alejandrorios.expose.utils.base.BasePresenter
import com.alejandrorios.expose.utils.base.BaseView

/**
 * @author alejandrorios on 8/30/20
 */
interface FavoritesContract {

    interface View: BaseView {

        fun showAnimeFavorites(animeFavorites: List<Anime>)

        fun showAnimeDetails(anime: Anime)
    }

    interface Presenter: BasePresenter<View> {

        fun onResumed()

        fun onAnimeClicked(anime: Anime)
    }
}
