package com.main.song_playing.di.modules

import com.main.song_playing.presentation.viewmodel.SongPlayingViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class SongPlayingPresentationModule {

    @Provides
    fun provideSongPlayingViewModelFactory(

    ): SongPlayingViewModelFactory {
        return SongPlayingViewModelFactory(

        )
    }
}