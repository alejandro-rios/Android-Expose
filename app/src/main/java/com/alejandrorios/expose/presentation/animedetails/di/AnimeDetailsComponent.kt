package com.alejandrorios.expose.presentation.animedetails.di

import com.alejandrorios.expose.di.ActivityScope
import com.alejandrorios.expose.di.AppComponent
import com.alejandrorios.expose.presentation.animedetails.AnimeDetailsActivity
import dagger.Component

/**
 * @author alejandrorios on 8/18/20
 */
@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [AnimeDetailsModule::class])
interface AnimeDetailsComponent {
    fun inject(actvitiy: AnimeDetailsActivity)
}
