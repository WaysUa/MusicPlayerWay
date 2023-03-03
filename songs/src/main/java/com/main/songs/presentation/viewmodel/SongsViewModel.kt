package com.main.songs.presentation.viewmodel

import com.main.core.base.BaseViewModel
import com.main.core.exception.AudioException
import com.main.core.exception.ExceptionMessages.AUDIO_FILES_IS_EMPTY
import com.main.songs.domain.navigation.SongsNavigation
import com.main.songs.domain.usecases.GetAllAudioFilesUseCase
import com.main.songs.presentation.communication.SongsCommunication

class SongsViewModel(
    private val songsCommunication: SongsCommunication,
    private val songsNavigation: SongsNavigation,
    private val getAllAudioFilesUseCase: GetAllAudioFilesUseCase
) : BaseViewModel() {

    fun getAllAudioFiles() {
        val result = getAllAudioFilesUseCase.execute()

        songsCommunication.mapAudioFiles(result.data.orEmpty())
        when (result.exception) {
            is AudioException -> songsCommunication.mapAudioErrors(AUDIO_FILES_IS_EMPTY)
        }
    }

}