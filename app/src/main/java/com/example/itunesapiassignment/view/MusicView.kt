package com.example.itunesapiassignment.view

import com.example.itunesapiassignment.model.remote.MusicResponse

interface MusicView {
    fun requestData()
    fun displayData(
        list: MusicResponse
    )

    fun initViews(it: MusicResponse)
}