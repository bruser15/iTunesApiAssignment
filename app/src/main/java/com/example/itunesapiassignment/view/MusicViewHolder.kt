package com.example.itunesapiassignment.view

import com.example.itunesapiassignment.R
import androidx.recyclerview.widget.RecyclerView
import com.example.itunesapiassignment.databinding.ItemLayoutBinding
import com.example.itunesapiassignment.model.remote.MusicItem
import com.squareup.picasso.Picasso

class MusicViewHolder (private val binding: ItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

        fun onBind(music: MusicItem, callback: (MusicItem) -> Unit){
            binding.tvArtistName.text =
                music.artistName
            binding.tvCollectionName.text =
                music.collectionName
            binding.tvPrice.text =binding.root.context.getString(
                R.string.price, music.trackPrice)


            Picasso.get()
                .load(music.artworkUrl60)
                .resize(120,120)
                .into(binding.ivAlbumArt)

            binding.root.setOnClickListener{
                callback(music)
            }
        }
}