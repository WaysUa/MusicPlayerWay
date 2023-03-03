package com.main.songs.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.main.core.base.BaseViewModelFactory
import com.main.songs.domain.navigation.SongsNavigation
import com.main.songs.domain.usecases.GetAllAudioFilesUseCase
import com.main.songs.presentation.communication.SongsCommunication

class SongsViewModelFactory(
    private val songsCommunication: SongsCommunication,
    private val songsNavigation: SongsNavigation,
    private val getAllAudioFilesUseCase: GetAllAudioFilesUseCase
) : BaseViewModelFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SongsViewModel(
            songsCommunication = songsCommunication,
            songsNavigation = songsNavigation,
            getAllAudioFilesUseCase = getAllAudioFilesUseCase
        ) as  T
    }
}