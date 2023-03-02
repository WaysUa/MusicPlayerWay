package com.main.songs.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.main.core.base.BaseFragment
import com.main.core.navigation.DeepLinks
import com.main.songs.R
import com.main.songs.databinding.FragmentSongsBinding
import github.com.st235.lib_expandablebottombar.navigation.ExpandableBottomBarNavigationUI

class SongsFragment : BaseFragment() {
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
    }
}