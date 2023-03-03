package com.main.songs.domain.repository

import com.main.core.Resource
import com.main.songs.data.AudioFile
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.mockito.Mockito
import org.mockito.kotlin.mock

class AudioRepositoryTest {

    private val audioRepository = mock<AudioRepository>()

    @Test
    fun `successful get all audio files`() {
        Mockito.`when`(audioRepository.getAllAudioFiles()).thenReturn(
            Resource.Success(listOf(AudioFile(1, "Title", "Artist", "Path")))
        )
        val result = audioRepository.getAllAudioFiles()
        Assertions.assertTrue(result.data?.isNotEmpty())
    }

    @Test
    fun `failure get all audio files, list of audio files is empty`() {
        Mockito.`when`(audioRepository.getAllAudioFiles()).thenReturn(
            Resource.Error(emptyList(), AudioException(AUDIO_FILES_IS_EMPTY))
        )
        val result = audioRepository.getAllAudioFiles()
        Assertions.assertTrue(result.exception?.message == AUDIO_FILES_IS_EMPTY)
    }
}