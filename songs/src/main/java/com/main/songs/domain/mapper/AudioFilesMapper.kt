package com.main.songs.domain.mapper

import com.main.core.entities.AudioFile

interface AudioFilesMapper {

    fun mapAudioFiles(audioFiles: List<AudioFile>)

    fun mapTextLength(length: Int, text: String): String
}