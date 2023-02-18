package com.jkl.wwtestapp.main.presentation

import com.jkl.wwtestapp.main.domain.ConfigFact
import com.jkl.wwtestapp.main.domain.ConfigResult

class ConfigResultMapper(
    private val communication: ConfigCommunication,
    private val mapper: ConfigFact.Mapper<ConfigUi>
) : ConfigResult.Mapper<Unit> {
    override fun map(config: ConfigFact, error: String) {
        if (error.isEmpty()) communication.showConfig(config.map(mapper))
    }
}