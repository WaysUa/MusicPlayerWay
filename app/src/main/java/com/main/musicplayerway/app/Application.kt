package com.main.musicplayerway.app

import android.app.Application
import com.main.songs.di.component.DaggerSongsComponent
import com.main.songs.di.component.SongsComponent
import com.main.songs.di.modules.SongsDataModule
import com.main.songs.di.modules.SongsDomainModule
import com.main.songs.di.modules.SongsPresentationModule
import com.main.songs.di.provider.ProvideSongsComponent

class Application : Application(), ProvideSongsComponent {

    private val songsComponent by lazy {
        DaggerSongsComponent
            .builder()
            .songsPresentationModule(SongsPresentationModule())
            .songsDomainModule(SongsDomainModule())
            .songsDataModule(SongsDataModule())
            .build()
    }

    override fun provideSongsComponent(): SongsComponent = songsComponent
}