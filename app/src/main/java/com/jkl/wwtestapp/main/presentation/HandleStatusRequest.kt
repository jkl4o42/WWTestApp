package com.jkl.wwtestapp.main.presentation

import com.jkl.wwtestapp.main.domain.ConfigResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

interface HandleStatusRequest {

    fun handle(
        coroutineScope: CoroutineScope,
        block: suspend () -> ConfigResult
    )

    class Base(
        private val dispatchers: DispatchersList,
        private val configResultMapper: ConfigResult.Mapper<Unit>,
    ) : HandleStatusRequest {
        override fun handle(coroutineScope: CoroutineScope, block: suspend () -> ConfigResult) {
            coroutineScope.launch(dispatchers.io()) {
                val result = block.invoke()
                result.map(configResultMapper)
            }
        }
    }
}