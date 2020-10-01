package com.alejandrorios.expose.presentation.navigation

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.alejandrorios.expose.utils.StringResourceId
import com.alejandrorios.expose.utils.base.BasePresenter
import com.alejandrorios.expose.utils.base.BaseView

/**
 * @author alejandrorios on 8/20/20
 */
interface NavigationContract {

    interface View: BaseView {

        fun loadFragment(
            newFragment: Fragment,
            newFragmentTag: String,
            currentFragmentTag: String
        )

        fun setToolbarTitle(@StringRes title: StringResourceId)
    }

    interface Presenter: BasePresenter<View> {

        fun onNavigationItemSelected(itemSelectedId: Int): Boolean
    }
}
