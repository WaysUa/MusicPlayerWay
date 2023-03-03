package com.main.songs.di.modules

import com.main.songs.data.realizations.AudioRepositoryImpl
import com.main.songs.domain.repositories.AudioRepository
import dagger.Module
import dagger.Provides

@Module
class SongsDataModule {

    @Provides
    fun provideAudioRepository(): AudioRepository {
        return AudioRepositoryImpl()
    }

}