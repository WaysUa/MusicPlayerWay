package com.main.core.di.modules

import com.main.core.communication.CoreAudioFileCommunication
import com.main.core.communication.CoreCommunication
import com.main.core.communication.CoreIsNeedToGoToBookReadingFragment
import com.main.core.viewmodel.CoreViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CoreModule {

    @Provides
    fun provideMainViewModelFactory(
        coreCommunication: CoreCommunication
    ): CoreViewModelFactory {
        return CoreViewModelFactory(coreCommunication)
    }

    @Provides
    fun provideMainCommunication(
        coreAudioFileCommunication: CoreAudioFileCommunication,
        coreIsNeedToGoToBookReadingFragment: CoreIsNeedToGoToBookReadingFragment
    ): CoreCommunication {
        return CoreCommunication.Base(
            coreAudioFileCommunication = coreAudioFileCommunication,
            coreIsNeedToGoToBookReadingFragment = coreIsNeedToGoToBookReadingFragment
        )
    }

    @Provides
    fun provideCoreAudioFileCommunication(): CoreAudioFileCommunication {
        return CoreAudioFileCommunication.Base()
    }

    @Provides
    fun provideCoreIsNeedToGoToBookReadingFragmentCommunication(): CoreIsNeedToGoToBookReadingFragment {
        return CoreIsNeedToGoToBookReadingFragment.Base()
    }
}