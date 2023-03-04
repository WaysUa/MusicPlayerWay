package com.main.songs.data.realizations

import android.content.Context
import android.provider.MediaStore
import androidx.core.content.ContentProviderCompat.requireContext
import com.main.core.Resource
import com.main.core.exception.AudioException
import com.main.core.exception.ExceptionMessages.AUDIO_FILES_IS_EMPTY
import com.main.songs.data.entities.AudioFile
import com.main.songs.domain.repositories.AudioRepository

class AudioRepositoryImpl : AudioRepository {

    override fun getAllAudioFiles(context: Context): Resource<List<AudioFile>> {
        val audioFiles = ArrayList<AudioFile>()
        val contentResolver = context.contentResolver
        val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.DATA
        )
        val cursor = contentResolver.query(uri, projection, null, null, null)
        cursor?.use {
            val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID)
            val titleColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)
            val artistColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)
            val dataColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)

            while (cursor.moveToNext()) {
                val id = cursor.getLong(idColumn)
                val title = cursor.getString(titleColumn)
                val artist = cursor.getString(artistColumn)
                val path = cursor.getString(dataColumn)
                val audioFile = AudioFile(id, title, artist, path)
                audioFiles.add(audioFile)
            }
        }
        return if (audioFiles.isNotEmpty()) {
            Resource.Success(audioFiles)
        } else {
            Resource.Error(emptyList(), AudioException(AUDIO_FILES_IS_EMPTY))
        }
    }
}