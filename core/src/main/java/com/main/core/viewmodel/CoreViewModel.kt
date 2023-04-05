package com.main.core.viewmodel

import com.main.core.base.BaseViewModel
import com.main.core.communication.CoreCommunication
import com.main.core.communication.MapCoreCommunication
import com.main.core.communication.ValueCoreCommunication
import com.main.core.entities.AudioFile

class CoreViewModel(
    private val coreCommunication: CoreCommunication
) : BaseViewModel(), MapCoreCommunication, ValueCoreCommunication {
    override fun manageAudioFile(audioFile: AudioFile) {
        coreCommunication.manageAudioFile(audioFile)
    }

    override fun manageIsNeedToGoToBookReadingFragment(value: Boolean) {
        coreCommunication.manageIsNeedToGoToBookReadingFragment(value)
    }

    override fun valueAudioFile(): AudioFile? {
        return coreCommunication.valueAudioFile()
    }


    override fun valueIsNeedToGoToBookReadingFragment(): Boolean? {
        return coreCommunication.valueIsNeedToGoToBookReadingFragment()
    }
}