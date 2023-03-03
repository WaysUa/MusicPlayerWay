package com.main.songs.domain.usecases

import com.main.core.Resource
import com.main.core.exception.AudioException
import com.main.core.exception.ExceptionMessages.AUDIO_FILES_IS_EMPTY
import com.main.songs.data.entities.AudioFile
import com.main.songs.domain.repositories.AudioRepository
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.mockito.Mockito
import org.mockito.kotlin.mock

class GetAllAudioFilesUseCaseTest {

    private val audioRepository = mock<AudioRepository>()
    private val getAllAudioFilesUseCase = GetAllAudioFilesUseCase(audioRepository)

    @Test
    fun `successful get all audio files`() {
        Mockito.`when`(audioRepository.getAllAudioFiles()).thenReturn(
            Resource.Success(listOf(AudioFile(1, "Title", "Artist", "Path")))
        )
        val result = getAllAudioFilesUseCase.execute()
        Assertions.assertTrue(result.data?.isNotEmpty() == true)
    }

    @Test
    fun `failure get all audio files, list of audio files is empty`() {
        Mockito.`when`(audioRepository.getAllAudioFiles()).thenReturn(
            Resource.Error(emptyList(), AudioException(AUDIO_FILES_IS_EMPTY))
        )
        val result = getAllAudioFilesUseCase.execute()
        Assertions.assertTrue(result.exception?.message == AUDIO_FILES_IS_EMPTY)
    }
}