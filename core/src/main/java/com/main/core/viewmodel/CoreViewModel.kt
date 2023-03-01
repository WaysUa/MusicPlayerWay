package com.main.core.viewmodel

import android.net.Uri
import com.main.core.base.BaseViewModel
import com.main.core.communication.CoreCommunication
import com.main.core.communication.MapCoreCommunication
import com.main.core.communication.ValueCoreCommunication

class CoreViewModel(
    private val coreCommunication: CoreCommunication
) : BaseViewModel(), MapCoreCommunication, ValueCoreCommunication {

    override fun manageUri(uri: Uri) {
        coreCommunication.manageUri(uri)
    }

    override fun manageIsNeedToGoToBookReadingFragment(value: Boolean) {
        coreCommunication.manageIsNeedToGoToBookReadingFragment(value)
    }

    override fun valueUri() = coreCommunication.valueUri()

    override fun valueIsNeedToGoToBookReadingFragment(): Boolean? {
        return coreCommunication.valueIsNeedToGoToBookReadingFragment()
    }
}