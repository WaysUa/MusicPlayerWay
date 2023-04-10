package com.main.song_playing.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.main.core.base.BaseFragment
import com.main.core.viewmodel.CoreViewModel
import com.main.core.viewmodel.CoreViewModelFactory
import com.main.song_playing.R
import com.main.song_playing.databinding.FragmentSongPlayingBinding
import com.main.song_playing.di.provider.ProvideSongPlayingComponent
import javax.inject.Inject

class SongPlayingFragment : BaseFragment() {
    private val binding by lazy { FragmentSongPlayingBinding.inflate(layoutInflater) }
    @Inject
    lateinit var coreViewModelFactory: CoreViewModelFactory
    private val coreViewModel: CoreViewModel by activityViewModels { coreViewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as ProvideSongPlayingComponent).provideSongPlayingComponent().inject(this)

        val audioFile = coreViewModel.valueAudioFile()
        binding.tvSongAuthor.text = audioFile?.artist
        binding.tvSongTitle.text = audioFile?.title
    }
}