package com.alejandrorios.expose.presentation.favorites

import com.alejandrorios.expose.AndroidExposeApplication
import com.alejandrorios.expose.presentation.favorites.di.DaggerFavoritesComponent
import com.alejandrorios.expose.presentation.favorites.di.FavoritesComponent
import com.alejandrorios.expose.presentation.favorites.di.FavoritesModule
import com.alejandrorios.expose.utils.base.BaseFragment

/**
 * @author alejandrorios on 8/30/20
 */
abstract class BaseFavoritesFragment(layout: Int) : BaseFragment(layout) {

    abstract fun injectFragmentBuilder(builder: FavoritesComponent)

    override fun prepareFragmentBuilder() {
        injectFragmentBuilder(
            DaggerFavoritesComponent.builder()
                .appComponent(AndroidExposeApplication.instance.getAppComponent(requireContext()))
                .favoritesModule(FavoritesModule())
                .build()
        )
    }
}
