package com.alejandrorios.expose.presentation.animetrends.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.alejandrorios.domain.model.Anime
import com.alejandrorios.expose.R
import com.alejandrorios.expose.databinding.AnimeTrendItemBinding

class AnimeTrendsAdapter(
    private val animeTrends: List<Anime>,
    private val animeDetailsListener: (Anime) -> Unit
) : RecyclerView.Adapter<AnimeTrendsAdapter.AnimeTrendsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeTrendsViewHolder =
        AnimeTrendsViewHolder(
            AnimeTrendItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = animeTrends.size

    override fun onBindViewHolder(holder: AnimeTrendsViewHolder, position: Int) {
        val animeItem = animeTrends[position]

        holder.run {
            bind(animeItem)
            itemView.setOnClickListener {
                animeDetailsListener.invoke(animeItem)
            }
        }
    }

    inner class AnimeTrendsViewHolder(private val binding: AnimeTrendItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(anime: Anime) {
            binding.run {
                ivAnimeImage.load(anime.attributes.posterImage?.medium)
                tvAnimeTrendTitle.text = anime.attributes.canonicalTitle
                tvFeedDate.text = String.format(tvFeedDate.context.getString(R.string.number_episodes), anime.attributes.episodeCount)
                tvAnimeTrendSynopsis.text = anime.attributes.synopsis
            }
        }
    }
}
