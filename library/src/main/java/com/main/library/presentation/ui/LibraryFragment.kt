package com.main.library.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.main.core.base.BaseFragment
import com.main.core.navigation.DeepLinks
import com.main.core.navigation.DeepLinks.LIBRARY_DEEP_LINK
import com.main.core.navigation.DeepLinks.SONGS_DEEP_LINK
import com.main.core.navigation.DeepLinks.STORE_DEEP_LINK
import com.main.library.R
import com.main.library.databinding.FragmentLibraryBinding
import github.com.st235.lib_expandablebottombar.navigation.ExpandableBottomBarNavigationUI

class LibraryFragment : BaseFragment() {
    private val binding by lazy { FragmentLibraryBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bottomNavigationBar.menu.select(com.main.core.R.id.itemLibrary)
        val navOptions = NavOptions.Builder().setPopUpTo(R.id.libraryNavGraph, true).build()
        binding.bottomNavigationBar.onItemSelectedListener = { selectedView, menuItem, _ ->
            when (menuItem.id) {
                com.main.core.R.id.itemSongs -> findNavController().navigate(SONGS_DEEP_LINK, navOptions)
                com.main.core.R.id.itemStore -> findNavController().navigate(STORE_DEEP_LINK, navOptions)
            }
        }
    }
}