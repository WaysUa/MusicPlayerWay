package com.main.song_playing.di.provider

import com.main.song_playing.di.component.SongPlayingComponent

interface ProvideSongPlayingComponent {
    fun provideSongPlayingComponent(): SongPlayingComponent
}