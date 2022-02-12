package com.example.itunesapiassignment.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.itunesapiassignment.databinding.ItemLayoutBinding
import com.example.itunesapiassignment.model.remote.MusicItem
import com.example.itunesapiassignment.model.remote.MusicResponse

class MusicAdapter (private val dataSet: List<MusicItem>,
                                     private val openDisplayFragment: (MusicItem) -> Unit):
    RecyclerView.Adapter<MusicViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MusicViewHolder(
            ItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.onBind(dataSet[position]){
            openDisplayFragment(it)
        }
    }

    override fun getItemCount() = dataSet.size

}