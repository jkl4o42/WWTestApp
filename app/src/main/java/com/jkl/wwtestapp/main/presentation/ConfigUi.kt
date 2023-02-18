package com.jkl.wwtestapp.main.presentation

data class ConfigUi(
    private val status: Boolean,
    private val link: String
) : Mapper<Screen, ConfigUi> {

    fun <T> map(mapper: Mapper<T>): T = mapper.map(status, link)

    interface Mapper<T> {
        fun map(status: Boolean, link: String): T
    }

    override fun map(source: ConfigUi): Screen =
        if (source.status) Screen.WebView else Screen.Game

    fun screen(source: ConfigUi, isLaunch: Boolean): Screen {
        return if (source.status || !isLaunch) Screen.WebView else Screen.Title
    }
}