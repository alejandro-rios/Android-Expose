package com.alejandrorios.expose.presentation.animedetails

import com.alejandrorios.expose.AndroidExposeApplication
import com.alejandrorios.expose.presentation.animedetails.di.AnimeDetailsComponent
import com.alejandrorios.expose.presentation.animedetails.di.AnimeDetailsModule
import com.alejandrorios.expose.presentation.animedetails.di.DaggerAnimeDetailsComponent
import com.alejandrorios.expose.utils.base.BaseActivity

/**
 * @author alejandrorios on 8/18/20
 */
abstract class BaseAnimeDetailsActivity : BaseActivity() {

    abstract fun injectActivityBuilder(builder: AnimeDetailsComponent)

    override fun prepareActivityBuilder() {
        injectActivityBuilder(
            DaggerAnimeDetailsComponent.builder()
                .appComponent(AndroidExposeApplication.instance.getAppComponent(this))
                .animeDetailsModule(AnimeDetailsModule())
                .build()
        )
    }
}
