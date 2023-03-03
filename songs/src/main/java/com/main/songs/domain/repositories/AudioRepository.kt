package com.main.songs.domain.repositories

import com.main.core.Resource
import com.main.songs.data.entities.AudioFile

interface AudioRepository {

    fun getAllAudioFiles() : Resource<List<AudioFile>>

}