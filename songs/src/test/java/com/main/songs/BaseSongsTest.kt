package com.main.songs

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.main.core.DispatchersList
import com.main.songs.data.AudioFile
import com.main.songs.presentation.communication.SongsAudioFilesCommunication
import com.main.songs.presentation.communication.SongsCommunication
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher

abstract class BaseSongsTest {

    protected class TestSongsCommunication : SongsCommunication {
        val audioFiles = mutableListOf<List<AudioFile>>()
        val audioErrors = mutableListOf<String>()

        override fun mapAudioFiles(audioFiles: List<AudioFile>) {
            this.audioFiles.add(audioFiles)
        }

        override fun mapAudioErrors(error: String) {
            audioErrors.add(error)
        }

        override fun observeAudioFiles(owner: LifecycleOwner, observer: Observer<List<AudioFile>>) = Unit

        override fun observeAudioErrors(owner: LifecycleOwner, observer: Observer<String>) = Unit
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    protected class TestDispatchersList(
        private val dispatcher: CoroutineDispatcher = UnconfinedTestDispatcher()
    ) : DispatchersList {

        override fun io(): CoroutineDispatcher = dispatcher
        override fun ui(): CoroutineDispatcher = dispatcher
    }
}