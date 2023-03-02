package com.main.store.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.main.core.base.BaseFragment
import com.main.core.navigation.DeepLinks
import com.main.store.R
import com.main.store.databinding.FragmentStoreBinding
import github.com.st235.lib_expandablebottombar.navigation.ExpandableBottomBarNavigationUI

class StoreFragment : BaseFragment() {
    private val binding by lazy { FragmentStoreBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navOptions = NavOptions.Builder().setPopUpTo(R.id.storeNavGraph, true).build()
        binding.bottomNavigationBar.menu.select(com.main.core.R.id.itemStore)
        binding.bottomNavigationBar.onItemSelectedListener = { selectedView, menuItem, _ ->
            when (menuItem.id) {
                com.main.core.R.id.itemLibrary -> findNavController().navigate(DeepLinks.LIBRARY_DEEP_LINK, navOptions)
                com.main.core.R.id.itemSongs -> findNavController().navigate(DeepLinks.SONGS_DEEP_LINK, navOptions)
            }
        }
    }
}