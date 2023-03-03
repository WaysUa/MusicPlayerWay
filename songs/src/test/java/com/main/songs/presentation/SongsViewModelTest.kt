package com.main.songs.presentation

import com.main.core.Resource
import com.main.core.exception.AudioException
import com.main.core.exception.ExceptionMessages.AUDIO_FILES_IS_EMPTY
import com.main.songs.BaseSongsTest
import com.main.songs.data.entities.AudioFile
import com.main.songs.domain.navigation.SongsNavigation
import com.main.songs.domain.repositories.AudioRepository
import com.main.songs.domain.usecases.GetAllAudioFilesUseCase
import com.main.songs.presentation.viewmodel.SongsViewModel
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.mockito.Mockito
import org.mockito.kotlin.mock

class SongsViewModelTest : BaseSongsTest() {

    private val audioRepository = mock<AudioRepository>()
    private val getAllAudioFilesUseCase = GetAllAudioFilesUseCase(audioRepository)
    private val songsCommunication = TestSongsCommunication()
    private val songsViewModel = SongsViewModel(
        songsCommunication = songsCommunication,
        songsNavigation = SongsNavigation.Base(),
        getAllAudioFilesUseCase = getAllAudioFilesUseCase
    )

    @Test
    fun `successful get all audio files`() {
        Mockito.`when`(audioRepository.getAllAudioFiles()).thenReturn(
            Resource.Success(listOf(AudioFile(1, "Title", "Artist", "Path")))
        )
        songsViewModel.getAllAudioFiles()
        Assertions.assertTrue(songsCommunication.audioFiles.first().isNotEmpty())
    }

    @Test
    fun `failure get all audio files, list of audio files is empty`() {
        Mockito.`when`(audioRepository.getAllAudioFiles()).thenReturn(
            Resource.Error(emptyList(), AudioException(AUDIO_FILES_IS_EMPTY))
        )
        songsViewModel.getAllAudioFiles()
        Assertions.assertTrue(songsCommunication.audioErrors.first() == AUDIO_FILES_IS_EMPTY)
    }
}