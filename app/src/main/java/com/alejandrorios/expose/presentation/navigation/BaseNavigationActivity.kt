package com.alejandrorios.expose.presentation.navigation

import com.alejandrorios.expose.AndroidExposeApplication
import com.alejandrorios.expose.presentation.navigation.di.DaggerNavigationComponent
import com.alejandrorios.expose.presentation.navigation.di.NavigationComponent
import com.alejandrorios.expose.presentation.navigation.di.NavigationModule
import com.alejandrorios.expose.utils.base.BaseActivity

/**
 * @author alejandrorios on 8/20/20
 */
abstract class BaseNavigationActivity : BaseActivity() {

    abstract fun injectActivityBuilder(builder: NavigationComponent)

    override fun prepareActivityBuilder() {
        injectActivityBuilder(
            DaggerNavigationComponent.builder()
                .appComponent(AndroidExposeApplication.instance.getAppComponent(this))
                .navigationModule(NavigationModule())
                .build()
        )
    }
}
