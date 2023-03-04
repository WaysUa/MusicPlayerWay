package com.main.songs.domain.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.main.core.navigation.DeepLinks
import com.main.songs.R

interface SongsNavigation {

    fun navigateToLibraryFragment(navController: NavController)

    fun navigateToStoreFragment(navController: NavController)

    class Base : SongsNavigation {

        override fun navigateToLibraryFragment(navController: NavController) {
            val navOptions = NavOptions.Builder().setPopUpTo(R.id.songsNavGraph, true).build()
            navController.navigate(DeepLinks.LIBRARY_DEEP_LINK, navOptions)
        }

        override fun navigateToStoreFragment(navController: NavController) {
            val navOptions = NavOptions.Builder().setPopUpTo(R.id.songsNavGraph, true).build()
            navController.navigate(DeepLinks.STORE_DEEP_LINK, navOptions)
        }
    }
}