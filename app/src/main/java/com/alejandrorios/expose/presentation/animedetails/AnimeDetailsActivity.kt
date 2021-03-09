package com.alejandrorios.expose.presentation.animedetails

import android.os.Bundle
import androidx.core.content.ContextCompat
import coil.load
import com.alejandrorios.domain.model.Anime
import com.alejandrorios.expose.R
import com.alejandrorios.expose.databinding.ActivityAnimeDetailsBinding
import com.alejandrorios.expose.presentation.animedetails.di.AnimeDetailsComponent
import com.alejandrorios.expose.utils.ARGUMENT_ANIME
import com.alejandrorios.expose.utils.viewBinding
import javax.inject.Inject

/**
 * @author alejandrorios on 8/18/20
 */
class AnimeDetailsActivity : BaseAnimeDetailsActivity(R.layout.activity_anime_details), AnimeDetailsContract.View {

    @Inject
    lateinit var presenter: AnimeDetailsContract.Presenter
    private val binding by viewBinding(ActivityAnimeDetailsBinding::inflate)
    private var anime: Anime? = null

    override fun injectActivityBuilder(builder: AnimeDetailsComponent) {
        builder.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anime_details)

        anime = intent?.extras?.getParcelable<Anime>(ARGUMENT_ANIME)
            ?: throw IllegalArgumentException("Anime item not provided")
    }

    override fun onResume() {
        super.onResume()
        lifecycle.addObserver(presenter)
        presenter.run {
            bind(this@AnimeDetailsActivity)
            onViewCreated(anime!!)
        }
    }

    override fun onStop() {
        super.onStop()
        presenter.unBind()
    }

    override fun displayAnimeDetails(anime: Anime) {
        binding.run {
            tvAnimeTitle.text = anime.attributes.canonicalTitle
            tvAnimeSynopsis.text = anime.attributes.synopsis
            tvAnimeTitleJp.text = anime.attributes.titles?.jaJp

            anime.attributes.coverImage?.let {
                ivDetailsImage.load(it.original) {
                    crossfade(true)
                }
            }

            ivAddAsFavorite.setOnClickListener {
                presenter.processFavorite(anime)
            }
        }
    }

    override fun markAsFavorite() {
        binding.ivAddAsFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite))
    }

    override fun unMarkAsFavorite() {
        binding.ivAddAsFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_border))
    }
}
