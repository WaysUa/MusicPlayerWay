package com.main.songs.domain.usecases

import com.main.core.Resource
import com.main.core.base.BaseUseCase
import com.main.songs.data.entities.AudioFile
import com.main.songs.domain.repositories.AudioRepository

class GetAllAudioFilesUseCase(
    private val audioRepository: AudioRepository
) : BaseUseCase() {

    fun execute(): Resource<List<AudioFile>> {
        return audioRepository.getAllAudioFiles()
    }
}