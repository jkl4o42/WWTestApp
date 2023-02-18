package com.jkl.wwtestapp.main.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jkl.wwtestapp.main.domain.ConfigFact
import com.jkl.wwtestapp.main.domain.ConfigResult
import com.jkl.wwtestapp.main.domain.MainInteractor


interface MainViewModel : Communication.Observe<NavigationStrategy>, FetchConfig,
    ObserveConfig {

    fun showFragment(config: ConfigUi, isLaunch: Boolean)

    class Base(
        private val navigationCommunication: NavigationCommunication.Mutable,
        private val interactor: MainInteractor,
        private val handleStatusRequest: HandleStatusRequest,
        private val communication: ConfigCommunication
    ) : ViewModel(), MainViewModel {

        override fun showFragment(config: ConfigUi, isLaunch: Boolean) {
            navigationCommunication.map(NavigationStrategy.Replace(config.screen(config, isLaunch)))
        }

        override fun observe(owner: LifecycleOwner, observer: Observer<NavigationStrategy>) =
            navigationCommunication.observe(owner, observer)

        override fun fetchConfig() =
            handleStatusRequest.handle(viewModelScope) { interactor.config() }

        override fun observeConfig(owner: LifecycleOwner, observer: Observer<ConfigUi>) {
            communication.observeConfig(owner, observer)
        }
    }
}

interface FetchConfig {
    fun fetchConfig()
}

interface ObserveConfig {
    fun observeConfig(owner: LifecycleOwner, observer: Observer<ConfigUi>)
}