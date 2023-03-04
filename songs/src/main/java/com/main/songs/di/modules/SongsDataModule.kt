package com.main.songs.di.modules

import android.content.Context
import com.main.songs.data.permissions.ManagePermissions
import com.main.songs.data.realizations.AudioRepositoryImpl
import com.main.songs.domain.repositories.AudioRepository
import dagger.Module
import dagger.Provides

@Module
class SongsDataModule(private val context: Context) {

    @Provides
    fun provideAudioRepository(): AudioRepository {
        return AudioRepositoryImpl()
    }

    @Provides
    fun provideManagePermissions(): ManagePermissions {
        return ManagePermissions.Base(context)
    }
}