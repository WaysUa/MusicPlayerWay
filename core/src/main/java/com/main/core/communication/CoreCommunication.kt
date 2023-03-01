package com.main.core.communication

import android.net.Uri

interface CoreCommunication : ValueCoreCommunication, MapCoreCommunication {

    class Base(
        private val coreContentUriCommunication: CoreContentUriCommunication,
        private val coreIsNeedToGoToBookReadingFragment: CoreIsNeedToGoToBookReadingFragment
    ): CoreCommunication {

        override fun manageUri(uri: Uri) {
            coreContentUriCommunication.map(uri)
        }

        override fun manageIsNeedToGoToBookReadingFragment(value: Boolean) {
            coreIsNeedToGoToBookReadingFragment.map(value)
        }

        override fun valueUri() = coreContentUriCommunication.value()

        override fun valueIsNeedToGoToBookReadingFragment(): Boolean? {
            return coreIsNeedToGoToBookReadingFragment.value()
        }
    }
}

interface ValueCoreCommunication {
    fun valueUri(): Uri?

    fun valueIsNeedToGoToBookReadingFragment(): Boolean?
}

interface MapCoreCommunication {

    fun manageUri(uri: Uri)

    fun manageIsNeedToGoToBookReadingFragment(value: Boolean)
}

interface CoreContentUriCommunication: Communication.Mutable<Uri> {
    class Base: Communication.Ui<Uri>(), CoreContentUriCommunication
}

interface CoreIsNeedToGoToBookReadingFragment: Communication.Mutable<Boolean> {
    class Base: Communication.Ui<Boolean>(), CoreIsNeedToGoToBookReadingFragment
}