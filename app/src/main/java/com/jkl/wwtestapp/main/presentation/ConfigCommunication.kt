package com.jkl.wwtestapp.main.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.jkl.wwtestapp.main.domain.ConfigFact

interface ConfigCommunication : ObserveConfig {

    fun showConfig(config: ConfigUi)

    class Base(
        private val configStateCommunication: ConfigStateCommunication
    ) : ConfigCommunication {

        override fun showConfig(config: ConfigUi) = configStateCommunication.map(config)

        override fun observeConfig(owner: LifecycleOwner, observer: Observer<ConfigUi>) {
            configStateCommunication.observe(owner, observer)
        }
    }
}

interface ConfigStateCommunication : Communication.Mutable<ConfigUi> {
    class Base : Communication.Post<ConfigUi>(), ConfigStateCommunication
}