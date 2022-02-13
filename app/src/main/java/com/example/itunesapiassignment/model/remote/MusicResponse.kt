package com.example.itunesapiassignment.model.remote


data class MusicResponse(
    val results: List<MusicItem>
)

data class MusicItem(
    val artistName: String,
    val collectionName: String,
    val artworkUrl60: String,
    val trackPrice: String?,
    val previewUrl: String
)