package com.main.songs.data.realizations

import com.main.core.Resource
import com.main.songs.data.entities.AudioFile
import com.main.songs.domain.repositories.AudioRepository

class AudioRepositoryImpl : AudioRepository {
    override fun getAllAudioFiles(): Resource<List<AudioFile>> {
        TODO("Not yet implemented")
    }
}