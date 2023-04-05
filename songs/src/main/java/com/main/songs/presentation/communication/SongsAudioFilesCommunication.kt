package com.main.songs.presentation.communication

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.main.core.communication.Communication
import com.main.core.entities.AudioFile

interface SongsCommunication : ObserveSongsCommunication {

    fun mapAudioFiles(audioFiles: List<AudioFile>)

    fun mapAudioErrors(error: String)

    class Base(
        private val songsAudioFilesCommunication: SongsAudioFilesCommunication,
        private val songsAudioErrorsCommunication: SongsAudioErrorsCommunication
    ): SongsCommunication {

        override fun mapAudioFiles(audioFiles: List<AudioFile>) {
            songsAudioFilesCommunication.map(audioFiles)
        }

        override fun mapAudioErrors(error: String) {
            songsAudioErrorsCommunication.map(error)
        }

        override fun observeAudioFiles(owner: LifecycleOwner, observer: Observer<List<AudioFile>>) {
            songsAudioFilesCommunication.observe(owner, observer)
        }

        override fun observeAudioErrors(owner: LifecycleOwner, observer: Observer<String>) {
            songsAudioErrorsCommunication.observe(owner, observer)
        }
    }
}

interface ObserveSongsCommunication {

    fun observeAudioFiles(owner: LifecycleOwner, observer: Observer<List<AudioFile>>)

    fun observeAudioErrors(owner: LifecycleOwner, observer: Observer<String>)
}

interface SongsAudioFilesCommunication : Communication.Mutable<List<AudioFile>> {
    class Base: Communication.Ui<List<AudioFile>>(), SongsAudioFilesCommunication
}

interface SongsAudioErrorsCommunication : Communication.Mutable<String> {
    class Base: Communication.Ui<String>(), SongsAudioErrorsCommunication
}