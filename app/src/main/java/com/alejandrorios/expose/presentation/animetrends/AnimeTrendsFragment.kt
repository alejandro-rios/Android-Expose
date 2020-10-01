package com.alejandrorios.expose.presentation.animetrends

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.alejandrorios.domain.model.Anime
import com.alejandrorios.expose.R
import com.alejandrorios.expose.presentation.animedetails.AnimeDetailsActivity
import com.alejandrorios.expose.presentation.animetrends.di.AnimeTrendsComponent
import com.alejandrorios.expose.utils.ARGUMENT_ANIME
import kotlinx.android.synthetic.main.fragment_anime_trends.rvAnimeTrends
import javax.inject.Inject

class AnimeTrendsFragment : BaseAnimeTrendsFragment(), AnimeTrendsContract.View {

    @Inject
    lateinit var presenter: AnimeTrendsContract.Presenter

    override fun injectFragmentBuilder(builder: AnimeTrendsComponent) {
        builder.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_anime_trends, container, false)
    }

    override fun onResume() {
        super.onResume()
        presenter.run {
            bind(this@AnimeTrendsFragment)
            onViewCreated()
        }
    }

    override fun onStop() {
        super.onStop()
        presenter.unBind()
    }

    override fun showAnimeTrends(animeTrends: List<Anime>) {
        rvAnimeTrends?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = AnimeTrendsAdapter(animeTrends, presenter)
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
