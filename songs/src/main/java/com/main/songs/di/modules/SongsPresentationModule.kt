package com.main.songs.di.modules

import com.main.songs.domain.navigation.SongsNavigation
import com.main.songs.domain.usecases.GetAllAudioFilesUseCase
import com.main.songs.presentation.communication.SongsAudioErrorsCommunication
import com.main.songs.presentation.communication.SongsAudioFilesCommunication
import com.main.songs.presentation.communication.SongsCommunication
import com.main.songs.presentation.viewmodel.SongsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class SongsPresentationModule {

    @Provides
    fun provideSongsViewModelFactory(
        songsCommunication: SongsCommunication,
        songsNavigation: SongsNavigation,
        getAllAudioFilesUseCase: GetAllAudioFilesUseCase
    ): SongsViewModelFactory {
        return SongsViewModelFactory(
            songsCommunication = songsCommunication,
            songsNavigation = songsNavigation,
            getAllAudioFilesUseCase = getAllAudioFilesUseCase
        )
    }

    @Provides
    fun provideSongsCommunication(
        songsAudioFilesCommunication: SongsAudioFilesCommunication,
        songsAudioErrorsCommunication: SongsAudioErrorsCommunication
    ): SongsCommunication {
        return SongsCommunication.Base(
            songsAudioFilesCommunication = songsAudioFilesCommunication,
            songsAudioErrorsCommunication = songsAudioErrorsCommunication
        )
    }

    @Provides
    fun provideSongsAudioFilesCommunication(): SongsAudioFilesCommunication {
        return SongsAudioFilesCommunication.Base()
    }

    @Provides
    fun provideSongsAudioErrorsCommunication(): SongsAudioErrorsCommunication {
        return SongsAudioErrorsCommunication.Base()
    }
}