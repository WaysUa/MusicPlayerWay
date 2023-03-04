package com.main.songs.presentation.ui

import android.Manifest
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.main.core.base.BaseFragment
import com.main.core.navigation.DeepLinks
import com.main.songs.R
import com.main.songs.data.entities.AudioFile
import com.main.songs.data.permissions.MultiplePermissionsListenerImpl
import com.main.songs.databinding.FragmentSongsBinding
import com.main.songs.di.provider.ProvideSongsComponent
import com.main.songs.presentation.viewmodel.SongsViewModel
import com.main.songs.presentation.viewmodel.SongsViewModelFactory
import javax.inject.Inject

class SongsFragment : BaseFragment() {
    private val binding by lazy { FragmentSongsBinding.inflate(layoutInflater) }
    @Inject
    lateinit var songsViewModelFactory: SongsViewModelFactory
    private val songsViewModel: SongsViewModel by activityViewModels { songsViewModelFactory }

    private val multiplePermissionsListener = MultiplePermissionsListenerImpl {
        songsViewModel.getAllAudioFiles(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as ProvideSongsComponent).provideSongsComponent().inject(this)

        binding.bottomNavigationBar.menu.select(com.main.core.R.id.itemSongs)
        binding.bottomNavigationBar.onItemSelectedListener = { _, menuItem, _ ->
            songsViewModel.manageMenuItem(menuItem, findNavController())
        }

        songsViewModel.requestPermission(
            permission = Manifest.permission.READ_EXTERNAL_STORAGE,
            multiplePermissionsListener = multiplePermissionsListener
        )

        songsViewModel.observeAudioFiles(this) { audioFiles ->
            Log.d("MyLog", audioFiles.joinToString())
        }

        songsViewModel.getAllAudioFiles(requireContext())
    }
}