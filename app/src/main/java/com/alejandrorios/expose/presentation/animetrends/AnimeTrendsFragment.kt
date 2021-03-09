package com.alejandrorios.expose.presentation.animetrends

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.alejandrorios.domain.model.Anime
import com.alejandrorios.expose.R
import com.alejandrorios.expose.databinding.FragmentAnimeTrendsBinding
import com.alejandrorios.expose.presentation.animedetails.AnimeDetailsActivity
import com.alejandrorios.expose.presentation.animetrends.adapter.AnimeTrendsAdapter
import com.alejandrorios.expose.presentation.animetrends.di.AnimeTrendsComponent
import com.alejandrorios.expose.utils.ARGUMENT_ANIME
import com.alejandrorios.expose.utils.viewBinding
import javax.inject.Inject

class AnimeTrendsFragment : BaseAnimeTrendsFragment(R.layout.fragment_anime_trends), AnimeTrendsContract.View {

    @Inject
    lateinit var presenter: AnimeTrendsContract.Presenter
    private val binding by viewBinding(FragmentAnimeTrendsBinding::bind)

    override fun injectFragmentBuilder(builder: AnimeTrendsComponent) {
        builder.inject(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.run {
            bind(this@AnimeTrendsFragment)
            binding.rvAnimeTrends.adapter?.itemCount.takeIf { it == 0 }.run {
                onResumed()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        presenter.unBind()
    }

    override fun showAnimeTrends(animeTrends: List<Anime>) {
        binding.rvAnimeTrends.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = AnimeTrendsAdapter(animeTrends) {
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
        fun newInstance(): AnimeTrendsFragment {
            return AnimeTrendsFragment()
        }
    }
}
