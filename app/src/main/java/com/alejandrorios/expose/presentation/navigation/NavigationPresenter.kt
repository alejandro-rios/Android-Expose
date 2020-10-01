package com.alejandrorios.expose.presentation.navigation

import androidx.fragment.app.Fragment
import com.alejandrorios.expose.R
import com.alejandrorios.expose.presentation.animetrends.AnimeTrendsFragment
import com.alejandrorios.expose.presentation.favorites.FavoritesFragment
import com.alejandrorios.expose.utils.CoroutinesContextProvider
import com.alejandrorios.expose.utils.TAG_ANIME_TRENDS
import com.alejandrorios.expose.utils.TAG_FAVORITES
import com.alejandrorios.expose.utils.TAG_NONE
import kotlinx.coroutines.Job
import javax.inject.Inject

/**
 * @author alejandrorios on 8/20/20
 */
class NavigationPresenter @Inject constructor(
    override val coroutinesContextProvider: CoroutinesContextProvider
) : NavigationContract.Presenter {

    override val parentJob = Job()
    override var view: NavigationContract.View? = null
    private var animeTrendsFragment: AnimeTrendsFragment? = null
    private var favoritesFragment: FavoritesFragment? = null
    private var currentFragmentTag = TAG_NONE
    private var mainFragmentTag = TAG_NONE

    override fun onNavigationItemSelected(itemSelectedId: Int): Boolean {
//        view?.restoreBackStack()
        when (itemSelectedId) {
            R.id.navAnimeTrends -> {
                if (!isCurrentItemSelected(TAG_ANIME_TRENDS)) {
                    showAnimeTrendsFragmentSection()
                }
            }
            R.id.navFavorites -> {
                if (!isCurrentItemSelected(TAG_FAVORITES)) {
                    showFavoritesFragmentSection()
                }
            }
            else -> return false
        }
        return true
    }

    private fun isCurrentItemSelected(fragmentTag: String): Boolean {
        return fragmentTag == currentFragmentTag
    }

    private fun showCurrentToolbar(fragmentTag: String) {
        view?.setToolbarTitle(
            when (fragmentTag) {
                TAG_ANIME_TRENDS -> R.string.title_anime_trends
                TAG_FAVORITES -> R.string.title_favorites
                else -> R.string.title_anime_trends
            }
        )
    }

    private fun showAnimeTrendsFragmentSection() {
        view?.run {
            showCurrentToolbar(TAG_ANIME_TRENDS)
            view?.loadFragment(provideAnimeTrendsFragment(), TAG_ANIME_TRENDS, currentFragmentTag)
        }
        mainFragmentTag = TAG_ANIME_TRENDS
        currentFragmentTag = TAG_ANIME_TRENDS
    }

    private fun showFavoritesFragmentSection() {
        view?.run {
            showCurrentToolbar(TAG_FAVORITES)
            view?.loadFragment(provideFavoritesFragment(), TAG_FAVORITES, currentFragmentTag)
        }
        mainFragmentTag = TAG_FAVORITES
        currentFragmentTag = TAG_FAVORITES
    }

    private fun provideAnimeTrendsFragment(): Fragment {
        if (animeTrendsFragment == null)
            animeTrendsFragment = AnimeTrendsFragment.newInstance()
        return animeTrendsFragment!!
    }

    private fun provideFavoritesFragment(): Fragment {
        if (favoritesFragment == null)
            favoritesFragment = FavoritesFragment.newInstance()
        return favoritesFragment!!
    }
}
