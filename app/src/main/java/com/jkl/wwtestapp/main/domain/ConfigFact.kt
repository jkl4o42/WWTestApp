package com.jkl.wwtestapp.main.domain

data class ConfigFact(
    private val status: Boolean,
    private val link: String
) {
    interface Mapper<T> {
        fun map(status: Boolean, link: String): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(status, link)
}

