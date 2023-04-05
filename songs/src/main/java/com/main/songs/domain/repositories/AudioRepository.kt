package com.main.songs.domain.repositories

import android.content.Context
import com.main.core.Resource
import com.main.core.entities.AudioFile

interface AudioRepository {

    fun getAllAudioFiles(context: Context) : Resource<List<AudioFile>>

}