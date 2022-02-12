package com.example.itunesapiassignment.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {

    val api: Api by lazy {
        initRetrofit().create(Api::class.java)
    }

    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}