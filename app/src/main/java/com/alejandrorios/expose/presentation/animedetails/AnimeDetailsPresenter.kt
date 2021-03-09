package com.alejandrorios.expose.presentation.animedetails

import com.alejandrorios.domain.model.Anime
import com.alejandrorios.domain.usecase.IsAnimeFavoriteUseCase
import com.alejandrorios.domain.usecase.RemoveAnimeFavoriteUseCase
import com.alejandrorios.domain.usecase.UpdateAnimeFavoritesUseCase
import com.alejandrorios.expose.utils.CoroutinesContextProvider
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author alejandrorios on 8/18/20
 */
class AnimeDetailsPresenter @Inject constructor(
    override val coroutinesContextProvider: CoroutinesContextProvider,
    private val isAnimeFavoriteUseCase: IsAnimeFavoriteUseCase,
    private val updateAnimeFavoritesUseCase: UpdateAnimeFavoritesUseCase,
    private val removeAnimeFavoriteUseCase: RemoveAnimeFavoriteUseCase,
) : AnimeDetailsContract.Presenter {

    override val parentJob = Job()
    override var view: AnimeDetailsContract.View? = null
    private var isMarkedAsFavorite = false

    override fun onViewCreated(anime: Anime) {
        isFavorite(anime.id)
        view?.displayAnimeDetails(anime)
    }

    private fun isFavorite(animeId: Int) {
        launchJob {
            runCatching {
                withContext(coroutinesContextProvider.backgroundContext) {
                    isAnimeFavoriteUseCase(animeId)
                }
            }.onSuccess { isFavorite ->
                isMarkedAsFavorite = isFavorite

                if(isFavorite) {
                    view?.markAsFavorite()
                } else {
                    view?.unMarkAsFavorite()
                }
            }.onFailure {
                it.printStackTrace()
            }
        }
    }

    override fun processFavorite(anime: Anime) {
        launchJob {
            runCatching {
                withContext(coroutinesContextProvider.backgroundContext) {
                    if(isMarkedAsFavorite) {
                        removeAnimeFavoriteUseCase(anime.id)
                    } else {
                        updateAnimeFavoritesUseCase(anime)
                    }

                    isMarkedAsFavorite = !isMarkedAsFavorite
                }
            }.onSuccess {
                if(isMarkedAsFavorite) {
                    view?.markAsFavorite()
                } else {
                    view?.unMarkAsFavorite()
                }
            }.onFailure {
                it.printStackTrace()
            }
        }
    }
}
