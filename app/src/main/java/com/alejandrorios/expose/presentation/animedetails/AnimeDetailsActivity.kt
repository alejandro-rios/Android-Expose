package com.alejandrorios.expose.presentation.animedetails

import android.os.Bundle
import com.alejandrorios.domain.model.Anime
import com.alejandrorios.expose.R
import com.alejandrorios.expose.presentation.animedetails.di.AnimeDetailsComponent
import com.alejandrorios.expose.utils.ARGUMENT_ANIME
import kotlinx.android.synthetic.main.activity_anime_details.tvAnimeTitle
import javax.inject.Inject

/**
 * @author alejandrorios on 8/18/20
 */
class AnimeDetailsActivity : BaseAnimeDetailsActivity(), AnimeDetailsContract.View {

    @Inject
    lateinit var presenter: AnimeDetailsContract.Presenter
    private var anime: Anime? = null

    override fun injectActivityBuilder(builder: AnimeDetailsComponent) {
        builder.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anime_details)

        anime =
            intent?.extras?.getParcelable<Anime>(ARGUMENT_ANIME)
                ?: throw IllegalArgumentException("Anime item not provided")
    }

    override fun onResume() {
        super.onResume()
        lifecycle.addObserver(presenter)
        presenter.run {
            bind(this@AnimeDetailsActivity)
            onViewCreated(anime)
        }
    }

    override fun onStop() {
        super.onStop()
        presenter.unBind()
    }

    override fun displayAnimeDetails(anime: Anime) {
        tvAnimeTitle?.text = anime.attributes.canonicalTitle
    }
}
