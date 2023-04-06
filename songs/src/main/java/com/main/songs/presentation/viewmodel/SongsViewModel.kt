package com.main.songs.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.main.core.base.BaseViewModel
import com.main.core.exception.AudioException
import com.main.core.exception.ExceptionMessages.AUDIO_FILES_IS_EMPTY
import com.main.core.entities.AudioFile
import com.main.songs.data.permissions.ManagePermissions
import com.main.songs.domain.navigation.SongsNavigation
import com.main.songs.domain.usecases.GetAllAudioFilesUseCase
import com.main.songs.presentation.communication.ObserveSongsCommunication
import com.main.songs.presentation.communication.SongsCommunication
import github.com.st235.lib_expandablebottombar.MenuItem

class SongsViewModel(
    private val songsCommunication: SongsCommunication,
    private val songsNavigation: SongsNavigation,
    private val getAllAudioFilesUseCase: GetAllAudioFilesUseCase,
    private val managePermissions: ManagePermissions
) : BaseViewModel(), ObserveSongsCommunication{

    fun getAllAudioFiles(context: Context) {
        val result = getAllAudioFilesUseCase.execute(context)

        songsCommunication.mapAudioFiles(result.data.orEmpty())
        when (result.exception) {
            is AudioException -> songsCommunication.mapAudioErrors(AUDIO_FILES_IS_EMPTY)
        }
    }

    fun manageMenuItem(menuItem: MenuItem, navController: NavController): Boolean {
        when (menuItem.id) {
            com.main.core.R.id.itemLibrary -> songsNavigation.navigateToLibraryFragment(navController)
            com.main.core.R.id.itemStore -> songsNavigation.navigateToStoreFragment(navController)
        }
        return true
    }

    fun requestPermission(
        permission: String, multiplePermissionsListener: MultiplePermissionsListener
    ) {
        managePermissions.requestPermission(permission, multiplePermissionsListener)
    }

    fun navigateToSongPlayingFragment(navController: NavController) {
        songsNavigation.navigateToSongPlayingFragment(navController)
    }

    override fun observeAudioFiles(owner: LifecycleOwner, observer: Observer<List<AudioFile>>) {
        songsCommunication.observeAudioFiles(owner, observer)
    }

    override fun observeAudioErrors(owner: LifecycleOwner, observer: Observer<String>) {
        songsCommunication.observeAudioErrors(owner, observer)
    }
}