package com.alejandrorios.expose.presentation.animetrends

import com.alejandrorios.domain.model.Anime
import com.alejandrorios.domain.usecase.GetAnimeTrendsUseCase
import com.alejandrorios.expose.utils.CoroutinesContextProvider
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author alejandrorios on 8/15/20
 */
class AnimeTrendsPresenter @Inject constructor(
    override val coroutinesContextProvider: CoroutinesContextProvider,
    private val getAnimeTrendsUseCase: GetAnimeTrendsUseCase
) : AnimeTrendsContract.Presenter {

    override val parentJob = Job()
    override var view: AnimeTrendsContract.View? = null

    override fun onViewCreated() {
        launchJob {
            runCatching {
                withContext(coroutinesContextProvider.backgroundContext) {
                    getAnimeTrendsUseCase()
                }
            }.onSuccess { animeTrends ->
                view?.showAnimeTrends(animeTrends)
            }.onFailure {
                it.printStackTrace()
            }
        }
    }

    override fun onAnimeTrendClicked(anime: Anime) {
        view?.showAnimeDetails(anime)
    }
}
