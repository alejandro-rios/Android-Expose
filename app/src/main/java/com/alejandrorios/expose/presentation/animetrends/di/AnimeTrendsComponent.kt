package com.alejandrorios.expose.presentation.animetrends.di

import com.alejandrorios.expose.di.AppComponent
import com.alejandrorios.expose.di.FragmentScope
import com.alejandrorios.expose.presentation.animetrends.AnimeTrendsFragment
import dagger.Component

/**
 * @author alejandrorios on 8/15/20
 */
@FragmentScope
@Component(dependencies = [AppComponent::class], modules = [AnimeTrendsModule::class])
interface AnimeTrendsComponent {
    fun inject(fragment: AnimeTrendsFragment)
}
