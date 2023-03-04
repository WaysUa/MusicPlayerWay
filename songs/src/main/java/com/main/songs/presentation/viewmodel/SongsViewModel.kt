package com.main.songs.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.main.core.base.BaseViewModel
import com.main.core.exception.AudioException
import com.main.core.exception.ExceptionMessages.AUDIO_FILES_IS_EMPTY
import com.main.songs.data.entities.AudioFile
import com.main.songs.domain.navigation.SongsNavigation
import com.main.songs.domain.usecases.GetAllAudioFilesUseCase
import com.main.songs.presentation.communication.ObserveSongsCommunication
import com.main.songs.presentation.communication.SongsCommunication

class SongsViewModel(
    private val songsCommunication: SongsCommunication,
    private val songsNavigation: SongsNavigation,
    private val getAllAudioFilesUseCase: GetAllAudioFilesUseCase
) : BaseViewModel(), ObserveSongsCommunication {

    fun getAllAudioFiles(context: Context) {
        val result = getAllAudioFilesUseCase.execute(context)

        songsCommunication.mapAudioFiles(result.data.orEmpty())
        when (result.exception) {
            is AudioException -> songsCommunication.mapAudioErrors(AUDIO_FILES_IS_EMPTY)
        }
    }

    override fun observeAudioFiles(owner: LifecycleOwner, observer: Observer<List<AudioFile>>) {
        songsCommunication.observeAudioFiles(owner, observer)
    }

    override fun observeAudioErrors(owner: LifecycleOwner, observer: Observer<String>) {
        songsCommunication.observeAudioErrors(owner, observer)
    }
}