package com.example.itunesapiassignment.view

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.itunesapiassignment.R
import com.example.itunesapiassignment.databinding.MusicFragmentLayoutBinding
import com.example.itunesapiassignment.model.remote.*
import com.example.itunesapiassignment.presenter.IPresenterMusic
import com.example.itunesapiassignment.presenter.PresenterMusic

class MusicFragment() : Fragment(), MusicView {


    private var position = 0
    private val presenter: IPresenterMusic by lazy {
        PresenterMusic()
    }
    private lateinit var mediaPlayer: MediaPlayer
    fun newInstance(pos: Int){
        position = pos
    }
    private lateinit var binding: MusicFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = MusicFragmentLayoutBinding.inflate(
            inflater,
            container,
            false
        )
        requestData()

        presenter.bind(this)
        return binding.root
    }

    override fun requestData() {

        when (position) {
            0 -> {
                binding.musicList.setBackgroundColor(resources.getColor(R.color.red))
                presenter.getMusic(TERM_ROCK)
            }
            2 -> {
                binding.musicList.setBackgroundColor(resources.getColor(R.color.pink))
                presenter.getMusic(TERM_POP)
            }
            else -> {
                binding.musicList.setBackgroundColor(resources.getColor(R.color.blue))
                presenter.getMusic(TERM_CLASSIC)
            }
        }
    }

    override fun displayData(list: MusicResponse) {
        mediaPlayer = MediaPlayer()
        binding.musicList.layoutManager = GridLayoutManager(context, 1)
        binding.musicList.adapter = MusicAdapter(list.results.map {
            MusicItem(
                it.artistName,
                it.collectionName,
                it.artworkUrl60,
                it.trackPrice,
                it.previewUrl
            )
        }) {
            if(mediaPlayer.isPlaying) {
                mediaPlayer.stop()
            }
            else{
                mediaPlayer = MediaPlayer.create(requireContext(), Uri.parse(it.previewUrl))
                mediaPlayer.start()
            }
        }
    }


    override fun onStop() {
        super.onStop()
        presenter.unBind()
    }
}