package com.jkl.wwtestapp.main.domain

interface HandleRequest {
    suspend fun handle(block: suspend () -> Unit): ConfigFact

    class Base(
        private val repository: MainRepository
    ) : HandleRequest {
        override suspend fun handle(block: suspend () -> Unit): ConfigFact {
            block.invoke()
            return repository.config()
        }
    }
}