package com.alejandrorios.expose.presentation.animetrends

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.alejandrorios.domain.model.Anime
import com.alejandrorios.expose.presentation.animedetails.AnimeDetailsListener
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.anime_trend_item.cvAnimeTrendItem
import kotlinx.android.synthetic.main.anime_trend_item.ivAnimeImage
import kotlinx.android.synthetic.main.anime_trend_item.tvAnimeTrendSynopsis
import kotlinx.android.synthetic.main.anime_trend_item.tvAnimeTrendTitle

/**
 * @author alejandrorios on 8/15/20
 */
class AnimeTrendsViewHolder(override val containerView: View) :
    RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(anime: Anime, animeDetailsListener: AnimeDetailsListener) {
        ivAnimeImage.load(anime.attributes.posterImage?.medium)
        tvAnimeTrendTitle.text = anime.attributes.canonicalTitle
        tvAnimeTrendSynopsis.text = anime.attributes.synopsis

        cvAnimeTrendItem.setOnClickListener {
            animeDetailsListener.onAnimeTrendClicked(anime)
        }
    }
}
