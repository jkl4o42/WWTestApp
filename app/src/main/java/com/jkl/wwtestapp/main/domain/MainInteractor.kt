package com.jkl.wwtestapp.main.domain

interface MainInteractor {

    suspend fun config(): ConfigResult

    class Base(
        private val repository: MainRepository
    ) : MainInteractor {

        override suspend fun config(): ConfigResult = try {
            ConfigResult.Success(repository.config())
        } catch (e: Exception) {
            ConfigResult.Failure(e.toString())
        }
    }
}