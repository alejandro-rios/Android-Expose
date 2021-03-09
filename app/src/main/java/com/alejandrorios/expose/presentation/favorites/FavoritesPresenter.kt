package com.alejandrorios.expose.presentation.favorites

import com.alejandrorios.domain.model.Anime
import com.alejandrorios.domain.usecase.GetAnimeFavoritesUseCase
import com.alejandrorios.expose.utils.CoroutinesContextProvider
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author alejandrorios on 8/30/20
 */
class FavoritesPresenter @Inject constructor(
    override val coroutinesContextProvider: CoroutinesContextProvider,
    private val getAnimeFavoritesUseCase: GetAnimeFavoritesUseCase
) : FavoritesContract.Presenter {

    override val parentJob = Job()
    override var view: FavoritesContract.View? = null

    override fun onResumed() {
        launchJob {
            runCatching {
                withContext(coroutinesContextProvider.backgroundContext) {
                    getAnimeFavoritesUseCase()
                }
            }.onSuccess { animeFavorites ->
                view?.showAnimeFavorites(animeFavorites)
            }.onFailure {
                it.printStackTrace()
            }
        }
    }

    override fun onAnimeClicked(anime: Anime) {
        view?.showAnimeDetails(anime)
    }
}
