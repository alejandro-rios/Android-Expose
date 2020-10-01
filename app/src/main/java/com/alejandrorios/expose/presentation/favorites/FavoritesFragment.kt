package com.alejandrorios.expose.presentation.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alejandrorios.expose.R
import com.alejandrorios.expose.presentation.favorites.di.FavoritesComponent
import javax.inject.Inject

/**
 * @author alejandrorios on 8/30/20
 */
class FavoritesFragment : BaseFavoritesFragment(), FavoritesContract.View {

    @Inject
    lateinit var presenter: FavoritesContract.Presenter

    override fun injectFragmentBuilder(builder: FavoritesComponent) {
        builder.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onResume() {
        super.onResume()
        presenter.run {
            bind(this@FavoritesFragment)
        }
    }

    companion object {
        fun newInstance(): FavoritesFragment {
            return FavoritesFragment()
        }
    }
}
