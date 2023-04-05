package com.main.core.communication

import com.main.core.entities.AudioFile

interface CoreCommunication : ValueCoreCommunication, MapCoreCommunication {

    class Base(
        private val coreAudioFileCommunication: CoreAudioFileCommunication,
        private val coreIsNeedToGoToBookReadingFragment: CoreIsNeedToGoToBookReadingFragment
    ): CoreCommunication {

        override fun manageIsNeedToGoToBookReadingFragment(value: Boolean) {
            coreIsNeedToGoToBookReadingFragment.map(value)
        }

        override fun valueAudioFile(): AudioFile? {
            return coreAudioFileCommunication.value()
        }


        override fun valueIsNeedToGoToBookReadingFragment(): Boolean? {
            return coreIsNeedToGoToBookReadingFragment.value()
        }

        override fun manageAudioFile(audioFile: AudioFile) {
            coreAudioFileCommunication.map(audioFile)
        }
    }
}

interface ValueCoreCommunication {
    fun valueAudioFile(): AudioFile?

    fun valueIsNeedToGoToBookReadingFragment(): Boolean?
}

interface MapCoreCommunication {

    fun manageAudioFile(audioFile: AudioFile)

    fun manageIsNeedToGoToBookReadingFragment(value: Boolean)
}

interface CoreAudioFileCommunication: Communication.Mutable<AudioFile> {
    class Base: Communication.Ui<AudioFile>(), CoreAudioFileCommunication
}

interface CoreIsNeedToGoToBookReadingFragment: Communication.Mutable<Boolean> {
    class Base: Communication.Ui<Boolean>(), CoreIsNeedToGoToBookReadingFragment
}