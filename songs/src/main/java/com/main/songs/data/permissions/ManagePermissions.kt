package com.main.songs.data.permissions

import android.Manifest
import android.content.Context
import com.karumi.dexter.Dexter
import com.karumi.dexter.listener.multi.MultiplePermissionsListener

interface ManagePermissions {

    fun requestPermission(
        permission: String, multiplePermissionsListener: MultiplePermissionsListener
    )

    class Base(
        private val context: Context
    ) : ManagePermissions {

        override fun requestPermission(
            permission: String, multiplePermissionsListener: MultiplePermissionsListener
        ) {
            Dexter.withContext(context)
                .withPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(multiplePermissionsListener)
                .check()
        }
    }
}