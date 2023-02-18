package com.jkl.wwtestapp.main.sl

import com.jkl.wwtestapp.main.data.BaseMainRepository
import com.jkl.wwtestapp.main.data.HandleDataRequest
import com.jkl.wwtestapp.main.data.cache.ConfigCacheDataSource
import com.jkl.wwtestapp.main.data.cloud.ConfigCloudDataSource
import com.jkl.wwtestapp.main.data.cloud.ConfigDataToFact
import com.jkl.wwtestapp.main.domain.ConfigUiMapper
import com.jkl.wwtestapp.main.domain.MainInteractor
import com.jkl.wwtestapp.main.presentation.*

class MainModule(
    private val core: Core
) : Module<MainViewModel.Base> {

    override fun viewModel(): MainViewModel.Base {
        val communication = ConfigCommunication.Base(
            ConfigStateCommunication.Base()
        )
        val viewModel = MainViewModel.Base(
            core.provideNavigation(),
            MainInteractor.Base(
                BaseMainRepository(
                    ConfigCloudDataSource.Base(),
                    ConfigCacheDataSource.Base(
                        core.provideSharedPref()
                    ),
                    HandleDataRequest.Base(ConfigDataToFact())
                )
            ),
            HandleStatusRequest.Base(
                DispatchersList.Base(),
                ConfigResultMapper(
                    communication,
                    ConfigUiMapper()
                )
            ),
            communication
        )
        return viewModel
    }
}