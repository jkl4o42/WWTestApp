package com.jkl.wwtestapp.main.data

import com.jkl.wwtestapp.main.domain.ConfigFact

interface HandleDataRequest {

    suspend fun handle(block: suspend () -> ConfigData): ConfigFact

    class Base(
        private val mapper: ConfigData.Mapper<ConfigFact>
    ) : HandleDataRequest {
        override suspend fun handle(block: suspend () -> ConfigData): ConfigFact =
            block.invoke().map(mapper)
    }
}