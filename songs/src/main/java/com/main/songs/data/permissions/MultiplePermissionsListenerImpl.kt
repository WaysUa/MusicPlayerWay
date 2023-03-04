package com.main.songs.data.permissions

import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener

class MultiplePermissionsListenerImpl(
    private val getAllAudioFiles: () -> (Unit)
) : MultiplePermissionsListener {
    override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
        getAllAudioFiles.invoke()
    }

    override fun onPermissionRationaleShouldBeShown(
        p0: MutableList<PermissionRequest>?, p1: PermissionToken?
    ) = Unit
}