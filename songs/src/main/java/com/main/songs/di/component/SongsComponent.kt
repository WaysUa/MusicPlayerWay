package com.main.songs.di.component

import com.main.core.di.modules.CoreModule
import com.main.songs.di.modules.SongsDataModule
import com.main.songs.di.modules.SongsDomainModule
import com.main.songs.di.modules.SongsPresentationModule
import com.main.songs.presentation.ui.SongsFragment
import dagger.Component

@Component(modules = [
    SongsPresentationModule::class,
    SongsDomainModule::class,
    SongsDataModule::class,
    CoreModule::class
])
interface SongsComponent {
    fun inject(songsFragment: SongsFragment)
}