package com.main.songs.di.provider

import com.main.songs.di.component.SongsComponent

interface ProvideSongsComponent {
    fun provideSongsComponent(): SongsComponent
}