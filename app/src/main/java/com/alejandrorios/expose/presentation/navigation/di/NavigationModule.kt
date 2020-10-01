package com.alejandrorios.expose.presentation.navigation.di

import com.alejandrorios.expose.presentation.navigation.NavigationContract
import com.alejandrorios.expose.presentation.navigation.NavigationPresenter
import dagger.Module
import dagger.Provides

/**
 * @author alejandrorios on 8/20/20
 */
@Module
class NavigationModule {

    @Provides
    fun provideNavigationPresenter(presenter: NavigationPresenter): NavigationContract.Presenter =
        presenter
}
