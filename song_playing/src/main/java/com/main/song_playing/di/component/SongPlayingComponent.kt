package com.main.song_playing.di.component

import com.main.core.di.modules.CoreModule
import com.main.song_playing.di.modules.SongPlayingDataModule
import com.main.song_playing.di.modules.SongPlayingDomainModule
import com.main.song_playing.di.modules.SongPlayingPresentationModule
import com.main.song_playing.presentation.ui.SongPlayingFragment
import dagger.Component

@Component(modules = [
    SongPlayingPresentationModule::class,
    SongPlayingDomainModule::class,
    SongPlayingDataModule::class,
    CoreModule::class
])
interface SongPlayingComponent {
    fun inject(songPlayingFragment: SongPlayingFragment)
}