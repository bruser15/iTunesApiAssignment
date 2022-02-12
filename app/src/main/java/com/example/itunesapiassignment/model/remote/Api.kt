package com.example.itunesapiassignment.model.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET(END_POINT)
    fun  getMusic(
        @Query("term") term: String = TERM_CLASSIC,
        @Query("amp;media") media: String = MEDIA,
        @Query("amp;entity") entity: String = ENTITY,
        @Query("amp;limit") limit: String = LIMIT
    ): Call<MusicResponse>

}