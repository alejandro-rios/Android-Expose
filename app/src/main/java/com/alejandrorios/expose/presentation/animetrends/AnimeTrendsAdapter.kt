package com.alejandrorios.expose.presentation.animetrends

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alejandrorios.domain.model.Anime
import com.alejandrorios.expose.R
import com.alejandrorios.expose.presentation.animedetails.AnimeDetailsListener

/**
 * @author alejandrorios on 8/15/20
 */
class AnimeTrendsAdapter(
    private val animeTrends: List<Anime>,
    private val animeDetailsListener: AnimeDetailsListener
) : RecyclerView.Adapter<AnimeTrendsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeTrendsViewHolder {
        return AnimeTrendsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.anime_trend_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return animeTrends.size
    }

    override fun onBindViewHolder(holder: AnimeTrendsViewHolder, position: Int) {
        holder.bind(animeTrends[position], animeDetailsListener)
    }
}
