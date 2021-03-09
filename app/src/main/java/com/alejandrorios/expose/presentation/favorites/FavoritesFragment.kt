package com.alejandrorios.expose.presentation.favorites

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.alejandrorios.domain.model.Anime
import com.alejandrorios.expose.R
import com.alejandrorios.expose.databinding.FragmentFavoritesBinding
import com.alejandrorios.expose.presentation.animedetails.AnimeDetailsActivity
import com.alejandrorios.expose.presentation.favorites.adapter.AnimeFavoritesAdapter
import com.alejandrorios.expose.presentation.favorites.di.FavoritesComponent
import com.alejandrorios.expose.utils.ARGUMENT_ANIME
import com.alejandrorios.expose.utils.viewBinding
import javax.inject.Inject

/**
 * @author alejandrorios on 8/30/20
 */
class FavoritesFragment : BaseFavoritesFragment(R.layout.fragment_favorites), FavoritesContract.View {

    @Inject
    lateinit var presenter: FavoritesContract.Presenter
    private val binding by viewBinding(FragmentFavoritesBinding::bind)

    override fun injectFragmentBuilder(builder: FavoritesComponent) {
        builder.inject(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.run {
            bind(this@FavoritesFragment)
            onResumed()
        }
    }

    override fun onStop() {
        super.onStop()
        presenter.unBind()
    }

    override fun showAnimeFavorites(animeFavorites: List<Anime>) {
        binding.rvAnimeFavorites.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = AnimeFavoritesAdapter(animeFavorites) {
                presenter.onAnimeClicked(it)
            }
        }
    }

    override fun showAnimeDetails(anime: Anime) {
        startActivity(
            Intent(requireActivity(), AnimeDetailsActivity::class.java).apply {
                putExtra(ARGUMENT_ANIME, anime)
            }
        )
    }

    companion object {
        fun newInstance(): FavoritesFragment {
            return FavoritesFragment()
        }
    }
}
