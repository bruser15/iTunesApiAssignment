package com.example.itunesapiassignment.presenter

import com.example.itunesapiassignment.model.remote.MusicResponse
import com.example.itunesapiassignment.model.remote.Network
import com.example.itunesapiassignment.view.MusicView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.NullPointerException

class PresenterMusic: IPresenterMusic {

    private var _view: MusicView? = null
    private val view: MusicView
        get() = _view ?: throw NullPointerException()

    override fun bind(view: MusicView) {
        _view = view
    }

    override fun unBind() {
        _view = null
    }

    override fun getMusic(genre: String) {
        Network.api.getMusic(genre).enqueue(
            object : Callback<MusicResponse> {
                override fun onResponse(
                    call: Call<MusicResponse>,
                    response: Response<MusicResponse>
                ) {
                    if(response.isSuccessful)
                        response.body()?.let { view.displayData(it) }
                }

                override fun onFailure(call: Call<MusicResponse>, t: Throwable) {
                    //TODO("ERROR")
                }

            }
        )
    }
}
