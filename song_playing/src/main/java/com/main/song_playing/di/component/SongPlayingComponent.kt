package com.main.song_playing.di.component

import com.main.song_playing.presentation.ui.SongPlayingFragment
import dagger.Component

@Component(modules = [

])
interface SongPlayingComponent {
    fun inject(songPlayingFragment: SongPlayingFragment)
}