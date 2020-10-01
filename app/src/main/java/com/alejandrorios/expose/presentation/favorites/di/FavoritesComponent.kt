package com.alejandrorios.expose.presentation.favorites.di

import com.alejandrorios.expose.di.AppComponent
import com.alejandrorios.expose.di.FragmentScope
import com.alejandrorios.expose.presentation.favorites.FavoritesFragment
import dagger.Component

/**
 * @author alejandrorios on 8/30/20
 */
@FragmentScope
@Component(dependencies = [AppComponent::class], modules = [FavoritesModule::class])
interface FavoritesComponent {
    fun inject(fragment: FavoritesFragment)
}
