package com.jkl.wwtestapp.main.domain

sealed class ConfigResult {

    interface Mapper<T> {
        fun map(config: ConfigFact, error: String): T
    }

    abstract fun <T> map(mapper: Mapper<T>): T

    data class Success(private val config: ConfigFact) : ConfigResult() {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map(config, "")
    }

    data class Failure(private val message: String) : ConfigResult() {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map(ConfigFact(false, ""), message)
    }
}