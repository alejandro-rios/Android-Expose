package com.alejandrorios.expose.presentation.favorites.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.alejandrorios.domain.model.Anime
import com.alejandrorios.expose.databinding.AnimeTrendItemBinding

class AnimeFavoritesAdapter(
    private val animeFavoritesTrends: List<Anime>,
    private val animeDetailsListener: (Anime) -> Unit
) : RecyclerView.Adapter<AnimeFavoritesAdapter.AnimeFavoritesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeFavoritesViewHolder =
        AnimeFavoritesViewHolder(
            AnimeTrendItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = animeFavoritesTrends.size

    override fun onBindViewHolder(holder: AnimeFavoritesViewHolder, position: Int) {
        val animeItem = animeFavoritesTrends[position]

        holder.run {
            bind(animeItem)
            itemView.setOnClickListener {
                animeDetailsListener.invoke(animeItem)
            }
        }
    }

    inner class AnimeFavoritesViewHolder(private val binding: AnimeTrendItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(anime: Anime) {
            binding.run {
                ivAnimeImage.load(anime.attributes.posterImage?.medium)
                tvAnimeTrendTitle.text = anime.attributes.canonicalTitle
                tvAnimeTrendSynopsis.text = anime.attributes.synopsis
            }
        }
    }
}
