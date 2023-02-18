package com.jkl.wwtestapp.main.data.cache

import android.content.SharedPreferences
import com.jkl.wwtestapp.main.data.ConfigData

interface ConfigCacheDataSource {

    suspend fun saveLink(config: ConfigData)

    suspend fun link(): String

    class Base(
        private val sharedPreferences: SharedPreferences
    ) : ConfigCacheDataSource {

        override suspend fun saveLink(config: ConfigData) {
            sharedPreferences.edit().putString(LINK, config.link()).apply()
        }

        override suspend fun link(): String {
            return sharedPreferences.getString(LINK, "") ?: ""
        }


    }

    companion object {
        private val LINK = "link"
    }
}