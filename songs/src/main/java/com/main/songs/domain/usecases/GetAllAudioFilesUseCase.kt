package com.main.songs.domain.usecases

import android.content.Context
import com.main.core.Resource
import com.main.core.base.BaseUseCase
import com.main.songs.data.entities.AudioFile
import com.main.songs.domain.repositories.AudioRepository

class GetAllAudioFilesUseCase(
    private val audioRepository: AudioRepository
) : BaseUseCase() {

    fun execute(context: Context): Resource<List<AudioFile>> {
        return audioRepository.getAllAudioFiles(context)
    }
}