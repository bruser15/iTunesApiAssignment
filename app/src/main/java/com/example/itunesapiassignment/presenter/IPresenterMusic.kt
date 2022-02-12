package com.example.itunesapiassignment.presenter

import com.example.itunesapiassignment.view.MusicView

interface IPresenterMusic {
    fun bind(view: MusicView)
    fun unBind()
    fun getMusic(genre: String)
}
