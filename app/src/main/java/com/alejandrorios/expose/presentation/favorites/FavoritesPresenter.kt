package com.alejandrorios.expose.presentation.favorites

import com.alejandrorios.expose.utils.CoroutinesContextProvider
import kotlinx.coroutines.Job
import javax.inject.Inject

/**
 * @author alejandrorios on 8/30/20
 */
class FavoritesPresenter @Inject constructor(
    override val coroutinesContextProvider: CoroutinesContextProvider
): FavoritesContract.Presenter {

    override val parentJob = Job()
    override var view: FavoritesContract.View? = null
}
