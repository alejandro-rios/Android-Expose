package com.alejandrorios.expose.presentation.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.alejandrorios.expose.R
import com.alejandrorios.expose.presentation.navigation.di.NavigationComponent
import com.alejandrorios.expose.utils.StringResourceId
import kotlinx.android.synthetic.main.activity_navigation.bottomNavAnime
import javax.inject.Inject

/**
 * @author alejandrorios on 8/20/20
 */
class NavigationActivity : BaseNavigationActivity(), NavigationContract.View {

    @Inject
    lateinit var presenter: NavigationContract.Presenter

    override fun injectActivityBuilder(builder: NavigationComponent) {
        builder.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        supportActionBar?.title = null

        presenter.bind(this)

        bottomNavAnime?.run {
            setOnNavigationItemSelectedListener { menuItem ->
                presenter.onNavigationItemSelected(menuItem.itemId)
            }
            selectedItemId = R.id.navAnimeTrends
        }
    }

    override fun loadFragment(
        newFragment: Fragment,
        newFragmentTag: String,
        currentFragmentTag: String
    ) {
        with(supportFragmentManager.beginTransaction()) {
            supportFragmentManager.findFragmentByTag(currentFragmentTag)
                ?.let { hide(it) }

            if (newFragment.isAdded) {
                show(newFragment)
            } else {
                add(R.id.flMainFragment, newFragment, newFragmentTag)
            }

            commitAllowingStateLoss()
        }
    }

    override fun setToolbarTitle(title: StringResourceId) {
        supportActionBar?.title = getString(title)
    }
}
