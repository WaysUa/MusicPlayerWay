package com.main.musicplayerway.app

import android.app.Application
import com.main.core.di.modules.CoreModule
import com.main.song_playing.di.component.DaggerSongPlayingComponent
import com.main.song_playing.di.component.SongPlayingComponent
import com.main.song_playing.di.modules.SongPlayingDataModule
import com.main.song_playing.di.modules.SongPlayingDomainModule
import com.main.song_playing.di.modules.SongPlayingPresentationModule
import com.main.song_playing.di.provider.ProvideSongPlayingComponent
import com.main.songs.di.component.DaggerSongsComponent
import com.main.songs.di.component.SongsComponent
import com.main.songs.di.modules.SongsDataModule
import com.main.songs.di.modules.SongsDomainModule
import com.main.songs.di.modules.SongsPresentationModule
import com.main.songs.di.provider.ProvideSongsComponent

class Application : Application(), ProvideSongsComponent, ProvideSongPlayingComponent {

    private val songsComponent by lazy {
        DaggerSongsComponent
            .builder()
            .songsPresentationModule(SongsPresentationModule())
            .songsDomainModule(SongsDomainModule())
            .songsDataModule(SongsDataModule(applicationContext))
            .coreModule(CoreModule())
            .build()
    }

    private val songPlayingComponent by lazy {
        DaggerSongPlayingComponent
            .builder()
            .songPlayingPresentationModule(SongPlayingPresentationModule())
            .songPlayingDomainModule(SongPlayingDomainModule())
            .songPlayingDataModule(SongPlayingDataModule())
            .coreModule(CoreModule())
            .build()
    }

    override fun provideSongsComponent(): SongsComponent = songsComponent
    override fun provideSongPlayingComponent(): SongPlayingComponent = songPlayingComponent
}