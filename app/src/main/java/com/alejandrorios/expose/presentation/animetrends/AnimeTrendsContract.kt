package com.alejandrorios.expose.presentation.animetrends

import com.alejandrorios.domain.model.Anime
import com.alejandrorios.expose.utils.base.BasePresenter
import com.alejandrorios.expose.utils.base.BaseView

/**
 * @author alejandrorios on 8/15/20
 */
interface AnimeTrendsContract {

    interface View : BaseView {

        fun showAnimeTrends(animeTrends: List<Anime>)

        fun showAnimeDetails(anime: Anime)
    }

    interface Presenter: BasePresenter<View> {

        fun onResumed()

        fun onAnimeClicked(anime: Anime)
    }
}
