package com.alejandrorios.expose.presentation.animetrends.di

import com.alejandrorios.expose.presentation.animetrends.AnimeTrendsContract
import com.alejandrorios.expose.presentation.animetrends.AnimeTrendsPresenter
import dagger.Module
import dagger.Provides

/**
 * @author alejandrorios on 8/15/20
 */
@Module
class AnimeTrendsModule {

    @Provides
    fun provideAnimeTrendsPresenter(presenter: AnimeTrendsPresenter): AnimeTrendsContract.Presenter =
        presenter
}
