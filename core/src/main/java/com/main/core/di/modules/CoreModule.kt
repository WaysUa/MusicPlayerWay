package com.main.core.di.modules

import com.main.core.communication.CoreCommunication
import com.main.core.communication.CoreContentUriCommunication
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
        coreContentUriCommunication: CoreContentUriCommunication,
        coreIsNeedToGoToBookReadingFragment: CoreIsNeedToGoToBookReadingFragment
    ): CoreCommunication {
        return CoreCommunication.Base(
            coreContentUriCommunication = coreContentUriCommunication,
            coreIsNeedToGoToBookReadingFragment = coreIsNeedToGoToBookReadingFragment
        )
    }

    @Provides
    fun provideCoreContentUriCommunication(): CoreContentUriCommunication {
        return CoreContentUriCommunication.Base()
    }

    @Provides
    fun provideCoreIsNeedToGoToBookReadingFragmentCommunication(): CoreIsNeedToGoToBookReadingFragment {
        return CoreIsNeedToGoToBookReadingFragment.Base()
    }
}