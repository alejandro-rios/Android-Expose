package com.alejandrorios.expose.presentation.animedetails

import com.alejandrorios.domain.model.Anime
import com.alejandrorios.expose.utils.CoroutinesContextProvider
import kotlinx.coroutines.Job
import javax.inject.Inject

/**
 * @author alejandrorios on 8/18/20
 */
class AnimeDetailsPresenter @Inject constructor(
    override val coroutinesContextProvider: CoroutinesContextProvider
) : AnimeDetailsContract.Presenter {

    override val parentJob = Job()
    override var view: AnimeDetailsContract.View? = null

    override fun onViewCreated(anime: Anime?) {
        anime?.let {
            view?.displayAnimeDetails(it)
        }
    }
}
