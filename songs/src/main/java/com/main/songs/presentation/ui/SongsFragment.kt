package com.main.songs.presentation.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.karumi.dexter.listener.single.PermissionListener
import com.main.core.base.BaseFragment
import com.main.core.navigation.DeepLinks
import com.main.songs.R
import com.main.songs.data.AudioFile
import com.main.songs.databinding.FragmentSongsBinding

class SongsFragment : BaseFragment(), MultiplePermissionsListener {
    private val binding by lazy { FragmentSongsBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bottomNavigationBar.menu.select(com.main.core.R.id.itemSongs)
        val navOptions = NavOptions.Builder().setPopUpTo(R.id.songsNavGraph, true).build()
        binding.bottomNavigationBar.onItemSelectedListener = { selectedView, menuItem, _ ->
            when (menuItem.id) {
                com.main.core.R.id.itemLibrary -> findNavController().navigate(DeepLinks.LIBRARY_DEEP_LINK, navOptions)
                com.main.core.R.id.itemStore -> findNavController().navigate(DeepLinks.STORE_DEEP_LINK, navOptions)
            }
        }

        Dexter.withContext(context)
            .withPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)
            .withListener(this)
            .check()

    }

    private fun getAllAudioFiles(): ArrayList<AudioFile> {
        val audioFiles = ArrayList<AudioFile>()
        val contentResolver = requireContext().contentResolver
        val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.DATA
        )
        val cursor = contentResolver.query(uri, projection, null, null, null)
        cursor?.use {
            val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID)
            val titleColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)
            val artistColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)
            val dataColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)

            while (cursor.moveToNext()) {
                val id = cursor.getLong(idColumn)
                val title = cursor.getString(titleColumn)
                val artist = cursor.getString(artistColumn)
                val path = cursor.getString(dataColumn)
                val audioFile = AudioFile(id, title, artist, path)
                audioFiles.add(audioFile)
            }
        }
        return audioFiles
    }

    override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
        if (p0?.areAllPermissionsGranted() == true) {
            getAllAudioFiles().forEachIndexed { index, audioFile ->
                Log.d("MyLog", "index: $index, audio: $audioFile")
            }
        }
    }

    override fun onPermissionRationaleShouldBeShown(
        p0: MutableList<PermissionRequest>?, p1: PermissionToken?
    ) = Unit
}