package com.alejandrorios.expose.utils.base

import android.content.Context
import androidx.fragment.app.Fragment

/**
 * @author alejandrorios on 8/20/20
 */
abstract class BaseFragment(layout: Int): Fragment(layout), BaseView {

    abstract fun prepareFragmentBuilder()

    override fun onAttach(context: Context) {
        super.onAttach(context)

        prepareFragmentBuilder()
    }
}
