package com.example.itunesapiassignment.model.remote

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET(END_POINT)
    fun  getMusic(
        @Query("term") term: String,
        @Query("media") media: String = MEDIA,
        @Query("entity") entity: String = ENTITY,
        @Query("limit") limit: Int = LIMIT
    ): Call<MusicResponse>

}