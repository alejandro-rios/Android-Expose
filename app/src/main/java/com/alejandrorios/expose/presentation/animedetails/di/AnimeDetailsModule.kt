package com.alejandrorios.expose.presentation.animedetails.di

import com.alejandrorios.expose.presentation.animedetails.AnimeDetailsContract
import com.alejandrorios.expose.presentation.animedetails.AnimeDetailsPresenter
import dagger.Module
import dagger.Provides

/**
 * @author alejandrorios on 8/18/20
 */
@Module
class AnimeDetailsModule {

    @Provides
    fun provideAnimeDetailsPresenter(presenter: AnimeDetailsPresenter): AnimeDetailsContract.Presenter =
        presenter
}
