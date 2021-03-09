package com.alejandrorios.expose.presentation.animetrends

import com.alejandrorios.expose.AndroidExposeApplication
import com.alejandrorios.expose.presentation.animetrends.di.AnimeTrendsComponent
import com.alejandrorios.expose.presentation.animetrends.di.AnimeTrendsModule
import com.alejandrorios.expose.presentation.animetrends.di.DaggerAnimeTrendsComponent
import com.alejandrorios.expose.utils.base.BaseFragment

/**
 * @author alejandrorios on 8/15/20
 */
abstract class BaseAnimeTrendsFragment(layout: Int) : BaseFragment(layout) {

    abstract fun injectFragmentBuilder(builder: AnimeTrendsComponent)

    override fun prepareFragmentBuilder() {
        injectFragmentBuilder(
            DaggerAnimeTrendsComponent.builder()
                .appComponent(AndroidExposeApplication.instance.getAppComponent(requireContext()))
                .animeTrendsModule(AnimeTrendsModule())
                .build()
        )
    }
}
