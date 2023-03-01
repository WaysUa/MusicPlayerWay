package com.main.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.main.core.base.BaseViewModelFactory
import com.main.core.communication.CoreCommunication

class CoreViewModelFactory(
    private val coreCommunication: CoreCommunication
) : BaseViewModelFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CoreViewModel(
            coreCommunication = coreCommunication
        ) as T
    }
}