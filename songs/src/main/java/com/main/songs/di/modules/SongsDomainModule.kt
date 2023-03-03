package com.main.songs.di.modules

import com.main.songs.domain.navigation.SongsNavigation
import com.main.songs.domain.repositories.AudioRepository
import com.main.songs.domain.usecases.GetAllAudioFilesUseCase
import dagger.Module
import dagger.Provides

@Module
class SongsDomainModule {

    @Provides
    fun provideSongsNavigation(): SongsNavigation {
        return SongsNavigation.Base()
    }

    @Provides
    fun provideGetAllAudioFilesUseCase(
        audioRepository: AudioRepository
    ): GetAllAudioFilesUseCase {
        return GetAllAudioFilesUseCase(audioRepository)
    }
}