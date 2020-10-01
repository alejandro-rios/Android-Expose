package com.alejandrorios.expose.presentation.navigation.di

import com.alejandrorios.expose.di.ActivityScope
import com.alejandrorios.expose.di.AppComponent
import com.alejandrorios.expose.presentation.navigation.NavigationActivity
import dagger.Component

/**
 * @author alejandrorios on 8/20/20
 */
@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [NavigationModule::class])
interface NavigationComponent {
    fun inject(activity: NavigationActivity)
}
