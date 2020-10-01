package com.alejandrorios.expose.presentation.favorites.di

import com.alejandrorios.expose.presentation.favorites.FavoritesContract
import com.alejandrorios.expose.presentation.favorites.FavoritesPresenter
import dagger.Module
import dagger.Provides

/**
 * @author alejandrorios on 8/30/20
 */
@Module
class FavoritesModule {

    @Provides
    fun provideFavoritesPresenter(presenter: FavoritesPresenter): FavoritesContract.Presenter = presenter
}
