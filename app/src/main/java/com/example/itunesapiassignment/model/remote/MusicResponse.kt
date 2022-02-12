package com.example.itunesapiassignment.model.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MusicResponse(
    val results: List<MusicItem>
): Parcelable

@Parcelize
data class MusicItem(
    val artistName: String,
    val collectionName: String,
    val artworkUrl60: String,
    val trackPrice: String?,
    val previewUrl: String
): Parcelable
